package com.melody.util.connnector;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: melody
 * @Date: 2020-04-02
 */
public class MyConnectors implements Runnable{

    boolean stopped;
    private String scheme = "http";

    public String getScheme() {
        return scheme;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            serverSocket = new ServerSocket(port,1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        while (!stopped){
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                continue;
            }

            HttpProcessor httpProcessor = new HttpProcessor();
            httpProcessor.process(socket);
        }
    }

    public void start(){
        Thread thread = new Thread(this);
        thread.start();
    }
}
