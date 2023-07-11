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
    comments = "Source: services/bank.proto")
public final class BankGrpc {

  private BankGrpc() {}

  public static final String SERVICE_NAME = "services.Bank";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<service.BankSignUpRequest,
      service.BankSignUpResponse> getSignUpMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "signUp",
      requestType = service.BankSignUpRequest.class,
      responseType = service.BankSignUpResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.BankSignUpRequest,
      service.BankSignUpResponse> getSignUpMethod() {
    io.grpc.MethodDescriptor<service.BankSignUpRequest, service.BankSignUpResponse> getSignUpMethod;
    if ((getSignUpMethod = BankGrpc.getSignUpMethod) == null) {
      synchronized (BankGrpc.class) {
        if ((getSignUpMethod = BankGrpc.getSignUpMethod) == null) {
          BankGrpc.getSignUpMethod = getSignUpMethod =
              io.grpc.MethodDescriptor.<service.BankSignUpRequest, service.BankSignUpResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "signUp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.BankSignUpRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.BankSignUpResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BankMethodDescriptorSupplier("signUp"))
              .build();
        }
      }
    }
    return getSignUpMethod;
  }

  private static volatile io.grpc.MethodDescriptor<service.BankRequest,
      service.BankResponse> getDepositMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deposit",
      requestType = service.BankRequest.class,
      responseType = service.BankResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.BankRequest,
      service.BankResponse> getDepositMethod() {
    io.grpc.MethodDescriptor<service.BankRequest, service.BankResponse> getDepositMethod;
    if ((getDepositMethod = BankGrpc.getDepositMethod) == null) {
      synchronized (BankGrpc.class) {
        if ((getDepositMethod = BankGrpc.getDepositMethod) == null) {
          BankGrpc.getDepositMethod = getDepositMethod =
              io.grpc.MethodDescriptor.<service.BankRequest, service.BankResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deposit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.BankRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.BankResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BankMethodDescriptorSupplier("deposit"))
              .build();
        }
      }
    }
    return getDepositMethod;
  }

  private static volatile io.grpc.MethodDescriptor<service.BankRequest,
      service.BankResponse> getWithdrawMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "withdraw",
      requestType = service.BankRequest.class,
      responseType = service.BankResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.BankRequest,
      service.BankResponse> getWithdrawMethod() {
    io.grpc.MethodDescriptor<service.BankRequest, service.BankResponse> getWithdrawMethod;
    if ((getWithdrawMethod = BankGrpc.getWithdrawMethod) == null) {
      synchronized (BankGrpc.class) {
        if ((getWithdrawMethod = BankGrpc.getWithdrawMethod) == null) {
          BankGrpc.getWithdrawMethod = getWithdrawMethod =
              io.grpc.MethodDescriptor.<service.BankRequest, service.BankResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "withdraw"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.BankRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.BankResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BankMethodDescriptorSupplier("withdraw"))
              .build();
        }
      }
    }
    return getWithdrawMethod;
  }

  private static volatile io.grpc.MethodDescriptor<service.BankAccountStatusRequest,
      service.BankAccountStatusResponse> getAccountStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "accountStatus",
      requestType = service.BankAccountStatusRequest.class,
      responseType = service.BankAccountStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.BankAccountStatusRequest,
      service.BankAccountStatusResponse> getAccountStatusMethod() {
    io.grpc.MethodDescriptor<service.BankAccountStatusRequest, service.BankAccountStatusResponse> getAccountStatusMethod;
    if ((getAccountStatusMethod = BankGrpc.getAccountStatusMethod) == null) {
      synchronized (BankGrpc.class) {
        if ((getAccountStatusMethod = BankGrpc.getAccountStatusMethod) == null) {
          BankGrpc.getAccountStatusMethod = getAccountStatusMethod =
              io.grpc.MethodDescriptor.<service.BankAccountStatusRequest, service.BankAccountStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "accountStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.BankAccountStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.BankAccountStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BankMethodDescriptorSupplier("accountStatus"))
              .build();
        }
      }
    }
    return getAccountStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BankStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BankStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BankStub>() {
        @java.lang.Override
        public BankStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BankStub(channel, callOptions);
        }
      };
    return BankStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BankBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BankBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BankBlockingStub>() {
        @java.lang.Override
        public BankBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BankBlockingStub(channel, callOptions);
        }
      };
    return BankBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BankFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BankFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BankFutureStub>() {
        @java.lang.Override
        public BankFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BankFutureStub(channel, callOptions);
        }
      };
    return BankFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class BankImplBase implements io.grpc.BindableService {

    /**
     */
    public void signUp(service.BankSignUpRequest request,
        io.grpc.stub.StreamObserver<service.BankSignUpResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSignUpMethod(), responseObserver);
    }

    /**
     */
    public void deposit(service.BankRequest request,
        io.grpc.stub.StreamObserver<service.BankResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDepositMethod(), responseObserver);
    }

    /**
     */
    public void withdraw(service.BankRequest request,
        io.grpc.stub.StreamObserver<service.BankResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getWithdrawMethod(), responseObserver);
    }

    /**
     */
    public void accountStatus(service.BankAccountStatusRequest request,
        io.grpc.stub.StreamObserver<service.BankAccountStatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAccountStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSignUpMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                service.BankSignUpRequest,
                service.BankSignUpResponse>(
                  this, METHODID_SIGN_UP)))
          .addMethod(
            getDepositMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                service.BankRequest,
                service.BankResponse>(
                  this, METHODID_DEPOSIT)))
          .addMethod(
            getWithdrawMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                service.BankRequest,
                service.BankResponse>(
                  this, METHODID_WITHDRAW)))
          .addMethod(
            getAccountStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                service.BankAccountStatusRequest,
                service.BankAccountStatusResponse>(
                  this, METHODID_ACCOUNT_STATUS)))
          .build();
    }
  }

  /**
   */
  public static final class BankStub extends io.grpc.stub.AbstractAsyncStub<BankStub> {
    private BankStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BankStub(channel, callOptions);
    }

    /**
     */
    public void signUp(service.BankSignUpRequest request,
        io.grpc.stub.StreamObserver<service.BankSignUpResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSignUpMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deposit(service.BankRequest request,
        io.grpc.stub.StreamObserver<service.BankResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDepositMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void withdraw(service.BankRequest request,
        io.grpc.stub.StreamObserver<service.BankResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWithdrawMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void accountStatus(service.BankAccountStatusRequest request,
        io.grpc.stub.StreamObserver<service.BankAccountStatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAccountStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BankBlockingStub extends io.grpc.stub.AbstractBlockingStub<BankBlockingStub> {
    private BankBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BankBlockingStub(channel, callOptions);
    }

    /**
     */
    public service.BankSignUpResponse signUp(service.BankSignUpRequest request) {
      return blockingUnaryCall(
          getChannel(), getSignUpMethod(), getCallOptions(), request);
    }

    /**
     */
    public service.BankResponse deposit(service.BankRequest request) {
      return blockingUnaryCall(
          getChannel(), getDepositMethod(), getCallOptions(), request);
    }

    /**
     */
    public service.BankResponse withdraw(service.BankRequest request) {
      return blockingUnaryCall(
          getChannel(), getWithdrawMethod(), getCallOptions(), request);
    }

    /**
     */
    public service.BankAccountStatusResponse accountStatus(service.BankAccountStatusRequest request) {
      return blockingUnaryCall(
          getChannel(), getAccountStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BankFutureStub extends io.grpc.stub.AbstractFutureStub<BankFutureStub> {
    private BankFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BankFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.BankSignUpResponse> signUp(
        service.BankSignUpRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSignUpMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.BankResponse> deposit(
        service.BankRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDepositMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.BankResponse> withdraw(
        service.BankRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWithdrawMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.BankAccountStatusResponse> accountStatus(
        service.BankAccountStatusRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAccountStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SIGN_UP = 0;
  private static final int METHODID_DEPOSIT = 1;
  private static final int METHODID_WITHDRAW = 2;
  private static final int METHODID_ACCOUNT_STATUS = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BankImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BankImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SIGN_UP:
          serviceImpl.signUp((service.BankSignUpRequest) request,
              (io.grpc.stub.StreamObserver<service.BankSignUpResponse>) responseObserver);
          break;
        case METHODID_DEPOSIT:
          serviceImpl.deposit((service.BankRequest) request,
              (io.grpc.stub.StreamObserver<service.BankResponse>) responseObserver);
          break;
        case METHODID_WITHDRAW:
          serviceImpl.withdraw((service.BankRequest) request,
              (io.grpc.stub.StreamObserver<service.BankResponse>) responseObserver);
          break;
        case METHODID_ACCOUNT_STATUS:
          serviceImpl.accountStatus((service.BankAccountStatusRequest) request,
              (io.grpc.stub.StreamObserver<service.BankAccountStatusResponse>) responseObserver);
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

  private static abstract class BankBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BankBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return service.BankProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Bank");
    }
  }

  private static final class BankFileDescriptorSupplier
      extends BankBaseDescriptorSupplier {
    BankFileDescriptorSupplier() {}
  }

  private static final class BankMethodDescriptorSupplier
      extends BankBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BankMethodDescriptorSupplier(String methodName) {
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
      synchronized (BankGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BankFileDescriptorSupplier())
              .addMethod(getSignUpMethod())
              .addMethod(getDepositMethod())
              .addMethod(getWithdrawMethod())
              .addMethod(getAccountStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
