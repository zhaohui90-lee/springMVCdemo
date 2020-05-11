package server;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: melody
 * @Date: 2020-05-09
 */
public class Request {

    private InputStream inputStream;
    private String uri;

    public String getUri() {
        return uri;
    }

    public Request(InputStream inputStream){
        this.inputStream = inputStream;
    }

    public static void main(String[] args) {

    }

    public void parse(){

        // 从套接字中读取一组字符
        StringBuffer request = new StringBuffer(2048);
        int i;
        byte[] buffer =  new byte[2048];
        try {
            i = inputStream.read(buffer);
        }catch (IOException e){
            e.printStackTrace();
            i = -1;
        }
        for (int j = 0; j < i; j++) {
            request.append(buffer[j]);
        }
        System.out.println(request.toString());
        uri = parseUri(request.toString());
    }

    private String parseUri(String requestString) {
        int index1,index2;
        index1 = requestString.indexOf(' ');
        if (index1 != -1){
            index2 = requestString.indexOf(' ',index1 + 1);
            if (index2 > index1){
                return requestString.substring(index1 + 1,index2);
            }
        }
        return null;
    }
}
