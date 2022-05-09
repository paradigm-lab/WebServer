package com.webserver;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws Exception{
        // Start receiving messages - ready to receive messages!
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server started. \nListening for messages.");

            while (true) {
                // Handle a new incoming message
                try(Socket client = serverSocket.accept()) {
                    // Client <------- messages queued up in it!!
                    System.out.println("Debug: got new message " + client.toString());

                    // Read the request - listen to the message

                    // Decide how we'd like to respond

                    // Just send back a simple "Hello World"

                    // Send back an image?

                    // Change response based on route?

                    // Send a response - send our reply

                    // Get ready for the next message
                }
            }
        }
    }
}
