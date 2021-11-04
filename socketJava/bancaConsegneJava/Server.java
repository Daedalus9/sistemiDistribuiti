import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

class Server {
    private static final int PORT = 7777;
    private static final int OPERATION_SIZE = 5;
    private static final String ERROR_MESSAGE = "ERROR";
    private static final String RESULT_MESSAGE = "OK";

    private static int bankAccount = -1;
    private static int[ ] conto = new int[10];


    static void sendMessage(DatagramSocket socket, DatagramPacket packet, InetAddress mittAddr, int mittPort, boolean opAccepted) {
        try {
            byte[] data = null;
            if(opAccepted) {
                data = new byte[RESULT_MESSAGE.length()];
                data = RESULT_MESSAGE.getBytes();
                
            }
            else {
                data = new byte[ERROR_MESSAGE.length()];
                data = ERROR_MESSAGE.getBytes();
            }
            packet = new DatagramPacket(data, data.length, mittAddr, mittPort);
            socket.send(packet);
        }
        catch(IOException e) {
            System.err.println("Error on send message: ");
            e.printStackTrace();
            return;
        }
        return;
    }

    static void setBankAccount(int op) {
        bankAccount = op;
        System.out.println("Bank account set to " + op);
        return;
    }

    static void deposit(DatagramSocket socket, DatagramPacket packet, String operation, InetAddress mittAddr, int mittPort) {
        if(bankAccount!=-1) {
            
            for(int i=1; i<operation.length(); i++) {
                if(!Character.isDigit(operation.charAt(i))) {
                    sendMessage(socket, packet, mittAddr, mittPort, false);
                    return;
                }
                
            }
            //int opInt = (int) operation.substring(1, operation.length());
            int opInt = Integer.parseInt(operation.substring(1, operation.length()));
            conto[bankAccount] += opInt;
            sendMessage(socket, packet, mittAddr, mittPort, true);
            System.out.println("Deposit operation on bank account " + bankAccount + " with value " + opInt);
            System.out.println("Total funds: " + conto[bankAccount]);     
        }
        else sendMessage(socket, packet, mittAddr, mittPort, false);
        return;
    }

    static void withdraw(DatagramSocket socket, DatagramPacket packet, String operation, InetAddress mittAddr, int mittPort) {
        if(bankAccount!=-1) {
            
            for(int i=1; i<operation.length(); i++) {
                if(!Character.isDigit(operation.charAt(i))) {
                    sendMessage(socket, packet, mittAddr, mittPort, false);
                    return;
                }
                
            }
            //int opInt = (int) operation.substring(1, operation.length());
            int opInt = Integer.parseInt(operation.substring(1, operation.length()));
            if(conto[bankAccount] - opInt < 0) {
                System.out.println("Invalid withdrawal operation on bank account " + bankAccount + " with value " + opInt + ": Negative balance");
                sendMessage(socket, packet, mittAddr, mittPort, false);
            }
            else {
                conto[bankAccount] -= opInt;
                sendMessage(socket, packet, mittAddr, mittPort, true);
                System.out.println("Withdrawal operation on bank account " + bankAccount + " with value " + opInt);
                System.out.println("Total funds: " + conto[bankAccount]); 
            }
                
        }
        else sendMessage(socket, packet, mittAddr, mittPort, false);
        return;
    }

    static void getBalance(DatagramSocket socket, DatagramPacket packet, InetAddress mittAddr, int mittPort) {
        if(bankAccount!=-1) {
            String balance = "Current balance on account " + String.valueOf(bankAccount) + ": " + String.valueOf(conto[bankAccount]);
            try {
                byte[] data = new byte[balance.length()];
                data = balance.getBytes();
                packet = new DatagramPacket(data, data.length, mittAddr, mittPort);
                socket.send(packet);
            }
            catch(IOException e) {
                System.err.println("Error on send message: ");
                e.printStackTrace();
                return;
            }
        }
        else sendMessage(socket, packet, mittAddr, mittPort, false);
        return;
    }
    
    public static void main(String[] args) {

        System.out.println("Starting server on port " + PORT);
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(PORT);
        }
        catch(SocketException e) {
            System.out.println("Unable to initialize socket: ");
            e.printStackTrace();
        }

        try {
            while(true) {
                String operation=null;
                DatagramPacket packet = null;
                InetAddress mittAddr = null;
                int mittPort = 0;
                try {
                    byte[ ] buf = new byte[256];
                    packet = new DatagramPacket(buf, buf.length);
                    socket.receive(packet);
                    mittAddr = packet.getAddress();
                    mittPort = packet.getPort();
                    operation = DatagramUtility.getContent(packet);
                }
                catch(IOException e) {
                    System.err.println("Error: ");
                    e.printStackTrace();
                    continue;
                }

                //System.out.println(operation.charAt(0));
                if(operation.charAt(0)=='U' && operation.length() == 2 && operation.charAt(1) >= '0' && operation.charAt(1) <= '9') {
                    int opInt = (int) operation.charAt(1) - '0';
                    setBankAccount(opInt);
                    sendMessage(socket, packet, mittAddr, mittPort, true);
                }
                else if(operation.charAt(0)=='V' && operation.length() == 5) deposit(socket, packet, operation, mittAddr, mittPort);
                else if(operation.charAt(0)=='P' && operation.length() == 5) withdraw(socket, packet, operation, mittAddr, mittPort);
                else if(operation.charAt(0)=='S' && operation.length()== 1) getBalance(socket, packet, mittAddr, mittPort);
                else sendMessage(socket, packet, mittAddr, mittPort, false);
            }
        }
        catch(Exception e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }
        System.out.println("Closing server...");
        socket.close();
    }
}