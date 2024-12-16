package org.learn.tech.io.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * User: jimjian
 * Date: 16-6-21 下午6:49
 */
public class JServer {
    public static void main(String[] args) {
        try {
            final ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("服务器正在运转...");
            while (true) {
                final Socket socket = serverSocket.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        BufferedReader bufferedReader = null;
                        PrintWriter printWriter = null;
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            System.out.println("接收到客户端信息：" + bufferedReader.readLine() + "，线程名：" + Thread.currentThread().getName());

                            printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
                            printWriter.println("小子我收到了~");
                            printWriter.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            if (printWriter != null) {
                                printWriter.close();
                            }
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
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
