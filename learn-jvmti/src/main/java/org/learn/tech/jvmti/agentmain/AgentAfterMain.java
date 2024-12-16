package org.learn.tech.jvmti.agentmain;

import java.lang.instrument.Instrumentation;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @create by jimjian on 2017/11/13 20:42
 **/
public class AgentAfterMain {

    private static final Pattern KV_PATTERN = Pattern.compile(",");
    private static Map<Object, Object> argMap = new HashMap<>();

    public static void agentmain(String args, Instrumentation inst) {
        if (args == null) {
            args = "";
        }
        String[] pairs = KV_PATTERN.split(args);
        for (String str : pairs) {
            String[] strings = str.split("=");
            argMap.put(strings[0], strings[1]);
        }
        System.out.println("[AgentMain] load agent after main 参数 : " + argMap);
        Class<?>[] classes = inst.getAllLoadedClasses();
        for (Class<?> cls : classes) {
            if (cls.getName().equals("AgentAfterMain")) {
                System.out.println("[AgentMain] agentClass 名称 : " + cls.getName());
            }
        }
        Thread thread = new Thread(new Runnable() {
            public void run() {
                socket();
            }
        });
        thread.setDaemon(true);
        thread.start();
        System.out.println("[AgentMain] 运行成功!");
    }

    public static void socket() {
        try {
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(argMap.get("port").toString()));
            System.out.println("[AgentMain] server socket 已启动!");
            while (true) {
                Socket socket = serverSocket.accept();
                BufferedReader bufferedReader = null;
                PrintWriter printWriter = null;
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    System.out.println("[AgentMain] 接收到Main发送到信息 : " + bufferedReader.readLine()
                            + ", 线程名 : " + Thread.currentThread().getName());
                    printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
                    printWriter.println("[AgentMain] 发送消息到 Main!");
                    printWriter.flush();
                } catch (IOException e) {
                    System.out.println("[AgentMain] errorMessage : " + e.getMessage());
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

