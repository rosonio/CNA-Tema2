package Services;

import Zodiac.ZodiacSign;
import Zodiac.ZodiacList;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import proto.ClientsGrpc;
import proto.ClientsOuterClass;

public class Clients extends ClientsGrpc.ClientsImplBase {
    @Override
    public void sendInfo(ClientsOuterClass.ClientRequest request, StreamObserver<ClientsOuterClass.ClientResponse> responseObserver){
        System.out.println("Date of Birth: " + request.getDateOfBirth());
        ClientsOuterClass.ClientResponse.Builder response = ClientsOuterClass.ClientResponse.newBuilder();

        ZodiacList zodiacList = new ZodiacList();
        String zodiacSignOfClient = zodiacList.ReturnSign(request.getDateOfBirth());
        System.out.println("The sign is: "+ zodiacSignOfClient);

        response.setZodiacSign(zodiacSignOfClient);

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}