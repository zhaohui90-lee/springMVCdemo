package com.melody.util.trade;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Author melody
 * @Date 2020-03-28
 */
public class HttpServer {

    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";
    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
    private boolean shutdown = false;

    public static void main(String[] args) throws IOException, InterruptedException {
//        socketSend();
        HttpServer httpServer = new HttpServer();
        httpServer.await();
    }

    public static void socketSend() throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1", 8080);
        OutputStream os = socket.getOutputStream();
        boolean autoflush = true;
        PrintWriter out = new PrintWriter(os,autoflush);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // send an http request to 8080
        out.println("GET /index.jsp HTTP/1.1");
        out.println("Host: localhost:8080");
        out.println("Connection:Close");
        out.println();

        // read response
        boolean loop = true;
        StringBuffer sb = new StringBuffer(8096);
        while (loop){
            if (in.ready()){
                int i = 0;
                while (i!=-1){
                    i = in.read();
                    sb.append(i);
                }
                loop = false;
            }
            Thread.sleep(50);
        }

        // display the response to the console
        System.out.println(sb.toString());
        socket.close();
    }

    public void await(){
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            serverSocket = new ServerSocket(port,1, InetAddress.getByName("127.0.0.1"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        // loop
        while (!shutdown){
            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;

            try {
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();
                // create request object and parse
                Request request = new Request(input);
                request.parse();

                // create Response object
                Response response = new Response(output);
                response.setRequest(request);
                // check if this is a request for a servlet or a static response
                if (request.getUri().startsWith("/servlet/")){

                }else{

                }
                response.sendStaticResponse();

                // close the socket
                socket.close();

                //check if the previous URI is a shutdown command
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
