package service;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.33.1)",
    comments = "Source: services/golf.proto")
public final class GolfGrpc {

  private GolfGrpc() {}

  public static final String SERVICE_NAME = "services.Golf";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<service.RecordScoreReq,
      service.RecordScoreRes> getRecordScoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "recordScore",
      requestType = service.RecordScoreReq.class,
      responseType = service.RecordScoreRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.RecordScoreReq,
      service.RecordScoreRes> getRecordScoreMethod() {
    io.grpc.MethodDescriptor<service.RecordScoreReq, service.RecordScoreRes> getRecordScoreMethod;
    if ((getRecordScoreMethod = GolfGrpc.getRecordScoreMethod) == null) {
      synchronized (GolfGrpc.class) {
        if ((getRecordScoreMethod = GolfGrpc.getRecordScoreMethod) == null) {
          GolfGrpc.getRecordScoreMethod = getRecordScoreMethod =
              io.grpc.MethodDescriptor.<service.RecordScoreReq, service.RecordScoreRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "recordScore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.RecordScoreReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.RecordScoreRes.getDefaultInstance()))
              .setSchemaDescriptor(new GolfMethodDescriptorSupplier("recordScore"))
              .build();
        }
      }
    }
    return getRecordScoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<service.NoMessage,
      service.AllScoresRes> getGetAllScoresMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllScores",
      requestType = service.NoMessage.class,
      responseType = service.AllScoresRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.NoMessage,
      service.AllScoresRes> getGetAllScoresMethod() {
    io.grpc.MethodDescriptor<service.NoMessage, service.AllScoresRes> getGetAllScoresMethod;
    if ((getGetAllScoresMethod = GolfGrpc.getGetAllScoresMethod) == null) {
      synchronized (GolfGrpc.class) {
        if ((getGetAllScoresMethod = GolfGrpc.getGetAllScoresMethod) == null) {
          GolfGrpc.getGetAllScoresMethod = getGetAllScoresMethod =
              io.grpc.MethodDescriptor.<service.NoMessage, service.AllScoresRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllScores"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.NoMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.AllScoresRes.getDefaultInstance()))
              .setSchemaDescriptor(new GolfMethodDescriptorSupplier("getAllScores"))
              .build();
        }
      }
    }
    return getGetAllScoresMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GolfStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GolfStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GolfStub>() {
        @java.lang.Override
        public GolfStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GolfStub(channel, callOptions);
        }
      };
    return GolfStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GolfBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GolfBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GolfBlockingStub>() {
        @java.lang.Override
        public GolfBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GolfBlockingStub(channel, callOptions);
        }
      };
    return GolfBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GolfFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GolfFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GolfFutureStub>() {
        @java.lang.Override
        public GolfFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GolfFutureStub(channel, callOptions);
        }
      };
    return GolfFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class GolfImplBase implements io.grpc.BindableService {

    /**
     */
    public void recordScore(service.RecordScoreReq request,
        io.grpc.stub.StreamObserver<service.RecordScoreRes> responseObserver) {
      asyncUnimplementedUnaryCall(getRecordScoreMethod(), responseObserver);
    }

    /**
     */
    public void getAllScores(service.NoMessage request,
        io.grpc.stub.StreamObserver<service.AllScoresRes> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllScoresMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRecordScoreMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                service.RecordScoreReq,
                service.RecordScoreRes>(
                  this, METHODID_RECORD_SCORE)))
          .addMethod(
            getGetAllScoresMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                service.NoMessage,
                service.AllScoresRes>(
                  this, METHODID_GET_ALL_SCORES)))
          .build();
    }
  }

  /**
   */
  public static final class GolfStub extends io.grpc.stub.AbstractAsyncStub<GolfStub> {
    private GolfStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GolfStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GolfStub(channel, callOptions);
    }

    /**
     */
    public void recordScore(service.RecordScoreReq request,
        io.grpc.stub.StreamObserver<service.RecordScoreRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRecordScoreMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllScores(service.NoMessage request,
        io.grpc.stub.StreamObserver<service.AllScoresRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllScoresMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GolfBlockingStub extends io.grpc.stub.AbstractBlockingStub<GolfBlockingStub> {
    private GolfBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GolfBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GolfBlockingStub(channel, callOptions);
    }

    /**
     */
    public service.RecordScoreRes recordScore(service.RecordScoreReq request) {
      return blockingUnaryCall(
          getChannel(), getRecordScoreMethod(), getCallOptions(), request);
    }

    /**
     */
    public service.AllScoresRes getAllScores(service.NoMessage request) {
      return blockingUnaryCall(
          getChannel(), getGetAllScoresMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GolfFutureStub extends io.grpc.stub.AbstractFutureStub<GolfFutureStub> {
    private GolfFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GolfFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GolfFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.RecordScoreRes> recordScore(
        service.RecordScoreReq request) {
      return futureUnaryCall(
          getChannel().newCall(getRecordScoreMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.AllScoresRes> getAllScores(
        service.NoMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllScoresMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RECORD_SCORE = 0;
  private static final int METHODID_GET_ALL_SCORES = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GolfImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GolfImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RECORD_SCORE:
          serviceImpl.recordScore((service.RecordScoreReq) request,
              (io.grpc.stub.StreamObserver<service.RecordScoreRes>) responseObserver);
          break;
        case METHODID_GET_ALL_SCORES:
          serviceImpl.getAllScores((service.NoMessage) request,
              (io.grpc.stub.StreamObserver<service.AllScoresRes>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GolfBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GolfBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return service.GolfProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Golf");
    }
  }

  private static final class GolfFileDescriptorSupplier
      extends GolfBaseDescriptorSupplier {
    GolfFileDescriptorSupplier() {}
  }

  private static final class GolfMethodDescriptorSupplier
      extends GolfBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GolfMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GolfGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GolfFileDescriptorSupplier())
              .addMethod(getRecordScoreMethod())
              .addMethod(getGetAllScoresMethod())
              .build();
        }
      }
    }
    return result;
  }
}
