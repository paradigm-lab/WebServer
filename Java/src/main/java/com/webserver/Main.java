package com.webserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
                    InputStreamReader inputStreamReader = new InputStreamReader(client.getInputStream());

                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                    // String's in java they can't be edited in the fly, but we can append things to the string which is called StringBuilder.
                    StringBuilder requestBuilder = new StringBuilder();

                    String line;  // Temp variable called line that holds one line at a time of our message
                    line = bufferedReader.readLine();

                    while (!(line.isBlank())) {
                        requestBuilder.append(line + "\r\n");
                        line = bufferedReader.readLine();
                    }

                    System.out.println("----REQUEST----");
                    System.out.println(requestBuilder);

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
