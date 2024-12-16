package org.learn.tech.jvmti.agentmain;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.net.Socket;

/**
 * @create by jimjian on 2017/11/12 12:27
 * jdk 1.8
 **/
public class RunAttach {

    private static final int port = 8090;

    public static void main(String[] args) throws Exception {
        loadAgent();
        socket();
    }

    public static void loadAgent() throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {
        VirtualMachine vm = VirtualMachine.attach(pid());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("name=简杰,age=25,port=").append(port);
        vm.loadAgent("/Users/jimjian/itest/java/instrumentation/agentmain/AgentAfterMain.jar", stringBuilder.toString());
    }

    private static String pid() {
        String pName = ManagementFactory.getRuntimeMXBean().getName();
        if (pName != null && pName.length() > 0) {
            String[] parts = pName.split("@");
            if (parts.length == 2) {
                return parts[0];
            }
        }
        return "-1";
    }

    public static void socket() {
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        Socket socket = null;
        try {
            socket = new Socket("localhost", port);
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            printWriter.println("[Main] 网速怎么那么慢啊!");
            printWriter.flush();

            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("[Main] 接收到agentMain服务的信息 : " + bufferedReader.readLine());
        } catch (IOException e) {
            System.out.println("[Main] errorMessage : " + e.getMessage());
        } finally {
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
}

