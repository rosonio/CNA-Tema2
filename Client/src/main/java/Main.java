import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import proto.ClientsGrpc;
import proto.ClientsOuterClass;

import java.util.Scanner;

public class Main {

    private static boolean DateVerification(String date) {
        if (date != "") {
            if (date.matches("^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$")) {
                String[] dateSplit = date.split("/");
                int month = Integer.parseInt(dateSplit[0]);
                int day = Integer.parseInt(dateSplit[1]);
                int year = Integer.parseInt(dateSplit[2]);

                //luna februarie
                if (month == 2 && year % 4 == 0 && year % 100 != 0 && year % 400 == 0 && day > 28) {
                    return false;
                } else { // luni cu 30 de zile
                    if ((month == 4 || month == 6) || month == 9 || month == 11 && day > 30) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8999).usePlaintext().build();

        ClientsGrpc.ClientsStub clientsStub = ClientsGrpc.newStub(channel);

        System.out.println("...........MENU...........");
        System.out.println("1. Enter your date of birth(mm/dd/yyyy");
        System.out.println("2. Quit");

        boolean isConnected =true;
        while(isConnected){
            Scanner input = new Scanner(System.in);
            System.out.println("Choose: ");
            int option=input.nextInt();

            switch(option){
                case 1:{
                    Scanner read= new Scanner(System.in).useDelimiter("\n");
                    System.out.println("Your birth date (mm/dd/yyyy) is: ");
                    String dateOfBirth = read.next();

                    if(DateVerification(dateOfBirth)) {
                        clientsStub.sendInfo(ClientsOuterClass.ClientRequest.newBuilder().setDateOfBirth(dateOfBirth).build(),
                                new StreamObserver<ClientsOuterClass.ClientResponse>() {
                                    @Override
                                    public void onNext(ClientsOuterClass.ClientResponse clientResponse) {
                                        System.out.println(clientResponse);
                                    }

                                    @Override
                                    public void onError(Throwable throwable) {
                                        System.out.println("Error: " + throwable.getMessage());
                                    }

                                    @Override
                                    public void onCompleted() {

                                    }
                                });
                    }
                    else{
                        System.out.println("Invalid date! Try again.");
                    }
                    break;
                }
                case 2:{
                    isConnected = false;
                    break;
                }
                default:
                    System.out.println("Unknown command, insert a valid command!");
            }
        }
        channel.shutdown();
    }
}
