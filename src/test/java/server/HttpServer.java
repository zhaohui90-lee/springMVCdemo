package server;

import com.melody.util.trade.Request;
import com.melody.util.trade.Response;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: melody
 * @Date: 2020-05-09
 */
public class HttpServer {

    public static final String WEB_ROOT = System.getProperty("user.dir") +
            File.separator + "webroot";

    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

    private boolean shutdown = false;

    public static void main(String[] args) {
        System.out.println(WEB_ROOT);
        HttpServer httpServer = new HttpServer();
        httpServer.await(8080);
    }

    public void await(int port){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port,1, InetAddress.getByName("127.0.0.1"));
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }

        while (!shutdown){
            Socket socket = null;
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                socket = serverSocket.accept();
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();

                // 创建一个请求对象并且解析
                Request request = new Request(inputStream);
                request.parse();

                // 创建一个返回对象
                Response response = new Response(outputStream);
                response.setRequest(request);
                response.sendStaticResponse();

                // 关闭套接字
                socket.close();

                // 检查前面的URI是否是关闭命令
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);


            }catch (IOException e){
                e.printStackTrace();

            }
        }
    }
}
