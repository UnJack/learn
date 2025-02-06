package org.learn.tech.io.net;

import java.io.*;
import java.net.Socket;

/**
 * User: jimjian
 * Date: 16-6-21 下午6:49
 */
public class JClient {

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        Socket socket = null;
        try {
            socket = new Socket("localhost", 9999);
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            printWriter.println("网速怎么那么慢啊~~~");
            printWriter.flush();

            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("接收到服务器的信息：" + bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
