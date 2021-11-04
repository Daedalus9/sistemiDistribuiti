import java.io.*;
import java.net.*;
import java.util.*;

class Client {
    public static final int PORT = 7777;
    
    public static void main(String[] args) {
        DatagramSocket socket = null;
        System.out.println("Opening client...");
        try {
            socket = new DatagramSocket();
            socket.setSoTimeout(3000);
        }
        catch(SocketException e) {
            System.out.println("Unable to initialize socket: ");
            e.printStackTrace();
            System.out.println("Closing client...");
            System.exit(1);
        }

        if(args.length < 2) {
            System.out.println("Too few args. Closing client...");
            System.exit(2);
        }

        InetAddress addr = null;

        try {
            addr = InetAddress.getByName(null);
        }
        catch(UnknownHostException e ) {
            System.out.println("Error on parsing server address: ");
            e.printStackTrace();
            System.out.println("Closing server");
            System.exit(3);
        }

        String operation = args[1];

        try {
            DatagramPacket packetOut = DatagramUtility.buildPacket(addr, PORT, operation);
            socket.send(packetOut);
            System.out.println("Operation " + operation + " sent to " + addr);
        }
        catch(IOException e) {
            System.out.println("Error on send operation: ");
            e.printStackTrace();
            System.out.println("Closing client...");
            System.exit(4);
        }   

        DatagramPacket packetIn = null;
        try {
            byte[] buf = new byte[256];
            packetIn = new DatagramPacket(buf, buf.length);
            socket.receive(packetIn);
        }
        catch (IOException e){
            System.out.println("Error on receive a message: ");
            e.printStackTrace();
            System.out.println("Closing client...");
            System.exit(5);
        }

        String message = new String(packetIn.getData());
        System.out.println(message);
        
    }
}
