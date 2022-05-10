package com.webserver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
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

                    // Read the first request from the client
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

                        // Get the first line of the request
                        // Get the second thing "resource" from the first line (Separated by spaces)
                        // Compare the "resource" to our list of things
                        // Send back the appropriate thing based on resources
                    

                    // Just send back a simple "Hello World"
                    /*
                    OutputStream clientOutput = client.getOutputStream();
                    clientOutput.write(("HTTP/1.1 200 OK \r\n").getBytes());
                    clientOutput.write(("\r\n").getBytes());
                    clientOutput.write(("THIS IS A SIMPLE WEB SERVER").getBytes());
                    clientOutput.flush();
                    */

                    // Send back an image?

                    // Load the image from the fileSystem
                    FileInputStream image = new FileInputStream("src/main/resources/fav.jpg");
                    System.out.println(image.toString());
                    // Turn the image into bytes?
                    // Set the contentType?

                    OutputStream clientOutput = client.getOutputStream();
                    clientOutput.write(("HTTP/1.1 200 OK \r\n").getBytes());
                    clientOutput.write(("\r\n").getBytes());
                    clientOutput.write(image.readAllBytes());
                    clientOutput.flush();


                    // Change response based on route?

                    // Send a response - send our reply

                    // Get ready for the next message
                    client.close();
                }
            }
        }
    }
}
