package example.grpcClient;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import service.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.protobuf.Empty;



public class EchoClient {


	private final EchoGrpc.EchoBlockingStub blockingStub1;
	private final JokeGrpc.JokeBlockingStub blockingStub2;
	private final ZooGrpc.ZooBlockingStub blockingStub3;
	private final CalculatorGrpc.CalculatorBlockingStub blockingStub4;
	private final GolfGrpc.GolfBlockingStub blockingStub5;
	


	/**
	 * Construct client for accessing server using the existing channel.
	 */
	public EchoClient(ManagedChannel channel) {
		blockingStub1 = EchoGrpc.newBlockingStub(channel);
		blockingStub2 = JokeGrpc.newBlockingStub(channel);
		blockingStub3 = ZooGrpc.newBlockingStub(channel);
		blockingStub4 = CalculatorGrpc.newBlockingStub(channel);
		blockingStub5 = GolfGrpc.newBlockingStub(channel);
	}

	public static void main(String[] args) throws Exception {
		if (args.length != 3) {
			System.out.println("Expected arguments: <host(String)> <port(int)> <auto(int)>");
			System.exit(1);
		}

		int port = 9099;
		int auto = 1;
		String host = args[0];
		try {
			port = Integer.parseInt(args[1]);
			auto = Integer.parseInt(args[2]);
		} catch (NumberFormatException nfe) {
			System.out.println("[Port] must be an integer");
			System.exit(2);
		}

		// Create a communication channel to the server, known as a Channel. Channels are thread-safe
		// and reusable. It is common to create channels at the beginning of your application and reuse
		// them until the application shuts down.
		// Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid needing certificates.
		String target = host + ":" + port;
		ManagedChannel channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();

		try {
			EchoClient client = new EchoClient(channel);
			if (auto != 1) {
				BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
				boolean quit = false;
				while (!quit) {
					// Menu
					System.out.println("\n*************************");
					System.out.println("         Menu");
					System.out.println("*************************");
					System.out.println("Select a service listed below.");
					System.out.println("1: Echo/parrot");
					System.out.println("2: Joke/setJoke");
					System.out.println("3: Joke/getJoke");
					System.out.println("4: Zoo/addAnimal");
					System.out.println("5: Zoo/animal_speak");
					System.out.println("6: Zoo/all_animal_speak");
					System.out.println("7: Calculator/evaluate");
					System.out.println("8: Calculator/history");
					System.out.println("9: Golf/course_record");
					System.out.println("10: Golf/record_score");
					System.out.println("0: Quit");

					String line = stdin.readLine();
					try {
						int selection = Integer.parseInt(line);
						if (selection >= 0 && selection < 11) {
							switch (selection) {
								case 0:
									quit = true;
									break;
								case 1:
									System.out.println("Enter the message you want the server to echo: ");
									String messageToEcho = stdin.readLine();
									client.askServerToParrot(messageToEcho);
									break;
								case 2:
									System.out.println("Enter the joke you'd like to set");
									String newJoke = stdin.readLine();
									client.setJoke(newJoke);
									break;
								case 3:
									System.out.println("How many jokes would you like?");
									String num = stdin.readLine();
									try {
										int jokeCount = Integer.parseInt(num);
										client.askForJokes(jokeCount);
									} catch (NumberFormatException nfe) {
										System.out.println("Error: not a valid number");
									}
									break;
								case 4:
									System.out.println("Enter the name of the animal: ");
									String animalName = stdin.readLine();
									System.out.println("Enter the type of the animal: ");
									String animalType = stdin.readLine();
									System.out.println("Enter the sound the animal makes: ");
									String animalSound = stdin.readLine();
									addAnimal(animalName, animalType, animalSound, client);
									break;
								case 5:
									System.out.println("Enter the name of the animal to speak: ");
									String speakAnimalName = stdin.readLine();
									speakAnimal(speakAnimalName, client);
									break;
								case 6:
									speakAllAnimals(client);
									break;
								// case 7:
								// 	System.out.println("******Calculator/Evaluate******");
								// 	System.out.println("Enter the first number: ");
								// 	int num1 = Integer.parseInt(stdin.readLine());
								// 	System.out.println("Enter the second number: ");
								// 	int num2 = Integer.parseInt(stdin.readLine());
								// 	System.out.println("Enter the operation (PLUS, MINUS, MULTIPLY, DIVIDE): ");
								// 	String operationString = stdin.readLine();
								// 	Expression.Operation operation = Expression.Operation.valueOf(operationString);

								// 	client.evaluateExpression(num1, num2, operation);
								// 	break;
								case 7:
									System.out.println("******Calculator/Evaluate******");
									try {
										System.out.println("Enter the first number: ");
										int num1 = Integer.parseInt(stdin.readLine());
										System.out.println("Enter the second number: ");
										int num2 = Integer.parseInt(stdin.readLine());
										System.out.println("Enter the operation (PLUS, MINUS, MULTIPLY, DIVIDE): ");
										String operationString = stdin.readLine();
										Expression.Operation operation = Expression.Operation.valueOf(operationString);

										client.evaluateExpression(num1, num2, operation);
									} catch (NumberFormatException e) {
										System.out.println("Error: Invalid number format");
									} catch (IllegalArgumentException e) {
										System.out.println("Error: Invalid operation");
									}
									break;
								case 8:
									System.out.println("******Calculator/History******");
									client.getHistory();
									break;
								case 9:
									System.out.println("******Course Scores******");
									client.getAllScores();
									break;
								case 10:
									System.out.println("******Record Your Score******");
									System.out.println("Enter your name: ");
									String golfName = stdin.readLine();
									System.out.println("Enter the course name: ");
									String courseName = stdin.readLine();
									System.out.println("Enter date played: ");
									String golfDate = stdin.readLine();
									System.out.println("Enter the score: ");
									String golfScore = stdin.readLine();
									try {
										client.setGolfScore(golfName, courseName, golfDate, Integer.parseInt(golfScore));
									} catch (NumberFormatException nfe) {
										System.out.println("Error with score entry.  Please try again.");
									}

									break;
								default:
									System.out.println("Error with selection");
							}
						}
					} catch (NumberFormatException e) {
						System.out.println("Enter an integer 0-10");
					}
				}

			} else {

				System.out.println("******************************************");
				System.out.println("Automated results for Echo/parrot");
				System.out.println("Simon says to Repeat this");
				client.askServerToParrot("Repeat this.");

				System.out.println("******************************************");
				System.out.println("Automated results for Joke/setJoke");
				client.setJoke("THIS IS THE JOKE BEING SET");

				System.out.println("******************************************");
				System.out.println("Automated results for Joke/getJoke");
				System.out.println("Get 4 Jokes");
				client.askForJokes(4);

				System.out.println("******************************************");
				System.out.println("Automated results for Zoo/add");
				System.out.println("Adding an animal to the zoo");
				String animalName = "Lion";
				String animalType = "Predator";
				String animalSound = "Roar";
				addAnimal(animalName, animalType, animalSound, client);

				System.out.println("******************************************");
				System.out.println("Automated results for Zoo/speak");
				System.out.println("Requesting Lion to speak");
				String speakAnimalName = "Lion";
				speakAnimal(speakAnimalName, client);

				System.out.println("******************************************");
				System.out.println("Automated results for Zoo/speakAll");
				System.out.println("Requesting all animals to speak");
				speakAllAnimals(client);

				System.out.println("******************************************");
				System.out.println("Automated results for Calculator/evaluate");
				int num1 = 10;
				int num2 = 5;
				Expression.Operation operation = Expression.Operation.PLUS;
				client.evaluateExpression(num1, num2, operation);

				System.out.println("******************************************");
				System.out.println("Automated results for Calculator/history");
				client.getHistory();


				System.out.println("******************************************");
				System.out.println("Automated results for Golf/recordScore");
				client.setGolfScore("Palak", "Links", "7.3.2022", 90);
				client.setGolfScore("Jim", "Augusta", "5.5.2021", 179);
				client.setGolfScore("John", "New Course", "9.3.2022", 65);

				System.out.println("******************************************");
				System.out.println("Automated results for Golf/getAllScores");
				client.getAllScores();
			}

		} finally {
			channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
		}
	}

	public void askServerToParrot(String message) {
		ClientRequest request = ClientRequest.newBuilder().setMessage(message).build();
		ServerResponse response;
		try {
			response = blockingStub1.parrot(request);
		} catch (Exception e) {
			System.err.println("RPC failed: " + e.getMessage());
			return;
		}
		System.out.println("Received from server: " + response.getMessage());
	}

	public void setJoke(String joke) {
		JokeSetReq request = JokeSetReq.newBuilder().setJoke(joke).build();
		JokeSetRes response;

		try {
			response = blockingStub2.setJoke(request);
			if (response.getOk()) {
				System.out.println("New Joke was set");
			} else {
				System.out.println("New joke was not set");
			}
		} catch (Exception e) {
			System.err.println("RPC failed: " + e);
		}
	}

	public void askForJokes(int num) {
		JokeReq request = JokeReq.newBuilder().setNumber(num).build();
		JokeRes response;

		try {
			response = blockingStub2.getJoke(request);
		} catch (Exception e) {
			System.err.println("RPC failed: " + e);
			return;
		}
		System.out.println("Your jokes: ");
		for (String joke : response.getJokeList()) {
			System.out.println("--- " + joke);
		}
	}

	public void getAllScores() {
		NoMessage.Builder request = NoMessage.newBuilder();
		AllScoresRes response;
		response = blockingStub5.getAllScores(request.build());
		if (response.getIsSuccess()) {
			List<CourseScoreEntry> scores = response.getScoresList();
			for (CourseScoreEntry entry : scores) {
				System.out.println("***Score***");
				System.out.println("Course = " + entry.getCourseName());
				System.out.println("Name = " + entry.getName());
				System.out.println("Date = " + entry.getDate());
				System.out.println("Score = " + entry.getScore());
				System.out.println("************");
			}
		} else {
			System.out.println(response.getError());
		}
	}

	public void setGolfScore(String name, String courseName, String date, int score) {
		RecordScoreReq.Builder request = RecordScoreReq.newBuilder().setName(name).setCourseName(courseName).setDate(date).setScore(score);
		RecordScoreRes response;
		try {
			response = blockingStub5.recordScore(request.build());
		} catch (Exception e) {
			System.err.println("RPC failed: " + e.getMessage());
			return;
		}

		if (response.getIsSuccess()) {
			System.out.println(response.getMessage());
		} else {
			System.out.println(response.getError());
		}

	}
	public static void addAnimal(String name, String type, String sound, EchoClient client) {
        Animal animal = Animal.newBuilder()
                .setName(name)
                .setType(type)
                .setAnimalSound(sound)
                .build();

        AddAnimalRequest request = AddAnimalRequest.newBuilder()
                .setAnimal(animal)
                .build();

        AddAnimalResponse response;
        try {
            response = client.blockingStub3.add(request);
        } catch (Exception e) {
            System.err.println("RPC failed: " + e.getMessage());
            return;
        }

        if (response.getIsSuccess()) {
            System.out.println("Animal added successfully");
        } else {
            System.out.println("Failed to add animal: " + response.getError());
        }
    }

	public static void speakAnimal(String animalName, EchoClient client) {
        SpeakRequest request = SpeakRequest.newBuilder()
                .setName(animalName)
                .build();

        SpeakResponse response;
        try {
            response = client.blockingStub3.speak(request);
        } catch (Exception e) {
            System.err.println("RPC failed: " + e.getMessage());
            return;
        }

        if (response.getIsSuccess()) {
            List<String> speakingAnimals = response.getAnimalsList();
            if (!speakingAnimals.isEmpty()) {
                System.out.println("Animal(s) speaking:");
                for (String animal : speakingAnimals) {
                    System.out.println("- " + animal);
                }
            } else {
                System.out.println("No animals found with the given name");
            }
        } else {
            System.out.println("Failed to speak animal: " + response.getError());
        }
    }
	public static void speakAllAnimals(EchoClient client) {
        SpeakResponse response;
        try {
            response = client.blockingStub3.speakAll(Empty.getDefaultInstance());
        } catch (Exception e) {
            System.err.println("RPC failed: " + e.getMessage());
            return;
        }

        if (response.getIsSuccess()) {
            List<String> speakingAnimals = response.getAnimalsList();
            if (!speakingAnimals.isEmpty()) {
                System.out.println("All animals speaking:");
                for (String animal : speakingAnimals) {
                    System.out.println( "- " + animal);
                }
            } else {
                System.out.println("No animals found in the zoo");
            }
        } else {
            System.out.println("Failed to speak all animals: " + response.getError());
        }
    }
	public void evaluateExpression(int num1, int num2, Expression.Operation operation) {
		Expression expression = Expression.newBuilder()
				.setNum1(num1)
				.setNum2(num2)
				.setOperation(operation)
				.build();
	
		EvaluateRequest request = EvaluateRequest.newBuilder()
				.setExpression(expression)
				.build();
	
		EvaluateResponse response;
		try {
			response = blockingStub4.evaluate(request);
			if (response.getIsSuccess()==1) {
				int result = response.getResult();
				System.out.println("Result: " + result);
			} else {
				String error = response.getError();
				System.out.println("Evaluation failed: " + error);
			}
		} catch (Exception e) {
			System.err.println("RPC failed: " + e.getMessage());
		}
	}

	public void getHistory() {
		Empty request = Empty.newBuilder().build();

		HistoryResponse response;
		try {
			response = blockingStub4.history(request);
			List<Expression> expressions = response.getExpressionsList();
			if (!expressions.isEmpty()) {
				System.out.println("Expression history:");
				for (Expression expression : expressions) {
					int num1 = expression.getNum1();
					int num2 = expression.getNum2();
					Expression.Operation operation = expression.getOperation();

					System.out.println(num1 + " " + operation.toString() + " " + num2);
				}
			} else {
				System.out.println("No history found");
			}
		} catch (Exception e) {
			System.err.println("RPC failed: " + e.getMessage());
		}
	}


}
