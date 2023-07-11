package example.grpcClient;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerMethodDefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Server that manages startup/shutdown of the `Node`.
 */
public class NodeService {
	static private Server server;
	int port;

	net.Network network;

	NodeService(int port) {
		this.port = port;
		this.network = new net.proto.Network();
	}

	/**
	 * Main launches the server from the command line.
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		if (args.length != 5) {
			System.out.println("Expected arguments: <regAddr(string)> <regPort(int)> <nodeAddr> <nodePort<int>");
			System.exit(1);
		}
		int regPort = 9003;
		int nodePort = 9099;
		try {
			regPort = Integer.parseInt(args[1]);
			nodePort = Integer.parseInt(args[3]);
		} catch (NumberFormatException nfe) {
			System.out.println("[Port] must be an integer");
			System.exit(2);
		}

		// Print input arguments
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		System.out.println(args[3]);
		System.out.println(args[4]);

		Register regThread = new Register(args[0], regPort, args[2], nodePort, args[4]);
		regThread.start();

		final NodeService server = new NodeService(nodePort);
		server.start();
		server.blockUntilShutdown();
	}

	private void start() throws IOException {
		/* The port on which the server should run */
		// Here we are adding the different services that a client can call
		ArrayList<String> services = new ArrayList<>();
		server = ServerBuilder.forPort(port)
				.addService(new EchoImpl())
				.addService(new JokeImpl())
				.addService(new ZooImpl())
				.addService(new CalculatorImpl())
				.addService(new GolfImpl())
				.addService(new RegistryAnswerImpl(services)).build().start();

		for (var service : server.getServices()) {
			// returns the services that are available from this node
			for (ServerMethodDefinition<?, ?> method : service.getMethods()) {
				services.add(method.getMethodDescriptor().getFullMethodName());
				System.out.println(method.getMethodDescriptor().getFullMethodName());
			}
		}

		System.out.println("Server running ...");
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				// Use stderr here since the logger may have been reset by its JVM shutdown hook.
				System.err.println("*** shutting down gRPC server since JVM is shutting down");
				try {
					NodeService.this.stop();
				} catch (InterruptedException e) {
					e.printStackTrace(System.err);
				}
				System.err.println("*** server shut down");
			}
		});
	}

	/**
	 * Await termination on the main thread since the grpc library uses daemon
	 * threads.
	 */
	private void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}

	private void stop() throws InterruptedException {
		if (server != null) {
			server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
		}
	}

}