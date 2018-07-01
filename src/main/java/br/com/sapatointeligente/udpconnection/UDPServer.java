package br.com.sapatointeligente.udpconnection;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

@Component
public class UDPServer extends Thread{

    private DatagramSocket socket;
    private boolean running;
    private byte[] buf = new byte[256];

    public UDPServer() throws SocketException {
        socket = new DatagramSocket(4445);
    }

    public void run() {
        running = true;

        System.out.println("Iniciando...");
        System.out.println("Socket: "+socket.getLocalAddress().getHostAddress());
        System.out.println("Socket: "+socket.getChannel());
        System.out.println("Socket: "+socket.getRemoteSocketAddress());
        System.out.println("Socket: "+socket.getChannel());
        while (running) {
            DatagramPacket packet
                    = new DatagramPacket(buf, buf.length);
            System.out.println("Connect ...");

            System.out.println("Endereço: "+socket.getLocalAddress() +": "+socket.getPort());

            try {
                //The receive() method blocks until a datagram is received. And the following code sends a DatagramPacket to the client
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //retrieve the address and port of the client, since we are going to send the response
            //back.
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(buf, buf.length, address, port);
            String received
                    = new String(packet.getData(), 0, packet.getLength());

            System.out.println("Endereço: "+ packet.getAddress());
            System.out.println(packet.getData());

            if (received.equals("end")) {
                System.out.println("End...");
                running = false;
                continue;
            }
            try {
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }

}
