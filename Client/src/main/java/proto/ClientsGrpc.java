package proto;

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
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: clients.proto")
public final class ClientsGrpc {

  private ClientsGrpc() {}

  public static final String SERVICE_NAME = "Clients";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.ClientsOuterClass.ClientRequest,
      proto.ClientsOuterClass.ClientResponse> getSendInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendInfo",
      requestType = proto.ClientsOuterClass.ClientRequest.class,
      responseType = proto.ClientsOuterClass.ClientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ClientsOuterClass.ClientRequest,
      proto.ClientsOuterClass.ClientResponse> getSendInfoMethod() {
    io.grpc.MethodDescriptor<proto.ClientsOuterClass.ClientRequest, proto.ClientsOuterClass.ClientResponse> getSendInfoMethod;
    if ((getSendInfoMethod = ClientsGrpc.getSendInfoMethod) == null) {
      synchronized (ClientsGrpc.class) {
        if ((getSendInfoMethod = ClientsGrpc.getSendInfoMethod) == null) {
          ClientsGrpc.getSendInfoMethod = getSendInfoMethod = 
              io.grpc.MethodDescriptor.<proto.ClientsOuterClass.ClientRequest, proto.ClientsOuterClass.ClientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Clients", "sendInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ClientsOuterClass.ClientRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ClientsOuterClass.ClientResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientsMethodDescriptorSupplier("sendInfo"))
                  .build();
          }
        }
     }
     return getSendInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClientsStub newStub(io.grpc.Channel channel) {
    return new ClientsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClientsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ClientsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ClientsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ClientsFutureStub(channel);
  }

  /**
   */
  public static abstract class ClientsImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendInfo(proto.ClientsOuterClass.ClientRequest request,
        io.grpc.stub.StreamObserver<proto.ClientsOuterClass.ClientResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendInfoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.ClientsOuterClass.ClientRequest,
                proto.ClientsOuterClass.ClientResponse>(
                  this, METHODID_SEND_INFO)))
          .build();
    }
  }

  /**
   */
  public static final class ClientsStub extends io.grpc.stub.AbstractStub<ClientsStub> {
    private ClientsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientsStub(channel, callOptions);
    }

    /**
     */
    public void sendInfo(proto.ClientsOuterClass.ClientRequest request,
        io.grpc.stub.StreamObserver<proto.ClientsOuterClass.ClientResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ClientsBlockingStub extends io.grpc.stub.AbstractStub<ClientsBlockingStub> {
    private ClientsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientsBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.ClientsOuterClass.ClientResponse sendInfo(proto.ClientsOuterClass.ClientRequest request) {
      return blockingUnaryCall(
          getChannel(), getSendInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ClientsFutureStub extends io.grpc.stub.AbstractStub<ClientsFutureStub> {
    private ClientsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ClientsOuterClass.ClientResponse> sendInfo(
        proto.ClientsOuterClass.ClientRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSendInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_INFO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ClientsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ClientsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_INFO:
          serviceImpl.sendInfo((proto.ClientsOuterClass.ClientRequest) request,
              (io.grpc.stub.StreamObserver<proto.ClientsOuterClass.ClientResponse>) responseObserver);
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

  private static abstract class ClientsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ClientsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.ClientsOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Clients");
    }
  }

  private static final class ClientsFileDescriptorSupplier
      extends ClientsBaseDescriptorSupplier {
    ClientsFileDescriptorSupplier() {}
  }

  private static final class ClientsMethodDescriptorSupplier
      extends ClientsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ClientsMethodDescriptorSupplier(String methodName) {
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
      synchronized (ClientsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClientsFileDescriptorSupplier())
              .addMethod(getSendInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
