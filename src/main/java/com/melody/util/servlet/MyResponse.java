package com.melody.util.servlet;

import com.melody.util.constants.Constants;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.*;
import java.util.Locale;

/**
 * @Author: melody
 * @Date: 2020-04-02
 */
public class MyResponse implements ServletResponse {
    private static final int BUFFER_SIZE = 1024;
    MyRequest request;
    OutputStream outputStream;
    PrintWriter writer;

    public MyResponse(OutputStream outputStream){
        this.outputStream = outputStream;
    }

    public void setRequest(MyRequest request){
        this.request = request;
    }

    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {
            File file = new File(Constants.WEB_ROOT,request.getUri());
            fis = new FileInputStream(file);

            int ch = fis.read(bytes,0,BUFFER_SIZE);
            while (ch != -1){
                outputStream.write(bytes,0,ch);
                ch = fis.read(bytes,0,BUFFER_SIZE);
            }
        } catch (IOException e) {
            String errorMessage = "HTTP/1.1 404 File not found\r\n" +
                    "Content-Type: text/html\r\n" +
                    "Content-Length: 23\r\n" +
                    "\r\n" +
                    "<h1>File not found</h1>";
            outputStream.write(errorMessage.getBytes());
        }finally {
            if (fis!=null){
                fis.close();
            }
        }
    }

    public PrintWriter getPrintWriter(){
        // autoflush is true,println() will flush
        // but print() will not
        writer = new PrintWriter(outputStream,true);
        return writer;
    }

    @Override
    public String getCharacterEncoding() {
        return null;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return null;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return null;
    }

    @Override
    public void setCharacterEncoding(String charset) {

    }

    @Override
    public void setContentLength(int len) {

    }

    @Override
    public void setContentLengthLong(long len) {

    }

    @Override
    public void setContentType(String type) {

    }

    @Override
    public void setBufferSize(int size) {

    }

    @Override
    public int getBufferSize() {
        return 0;
    }

    @Override
    public void flushBuffer() throws IOException {

    }

    @Override
    public void resetBuffer() {

    }

    @Override
    public boolean isCommitted() {
        return false;
    }

    @Override
    public void reset() {

    }

    @Override
    public void setLocale(Locale loc) {

    }

    @Override
    public Locale getLocale() {
        return null;
    }
}
