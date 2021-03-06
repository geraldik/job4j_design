package ru.job4j.io;

import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    boolean flag = true;
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        System.out.println(str);
                        if (flag) {
                            String message = str.split(" ")[1];
                            if ("/?msg=Hello".equals(message)) {
                                out.write("Hello.\r\n\r\n".getBytes());
                                flag = false;
                            } else if ("/?msg=Exit".equals(message)) {
                                server.close();
                            } else {
                                out.write("What.\r\n\r\n".getBytes());
                                flag = false;
                            }
                        }
                    }
                    out.flush();
                }
            }
        } catch (IOException e) {
            LOG.error("Message", e);
        }
    }
}