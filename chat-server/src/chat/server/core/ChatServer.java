package chat.server.core;

import network.ServerSocketThread;
import network.ServerSocketThreadListener;
import network.SocketThread;
import network.SocketThreadListener;

import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ChatServer implements ServerSocketThreadListener, SocketThreadListener {
    private final int SERVER_SOCKET_TIMEOUT = 2000;
    private final DateFormat DATE_FORMAT = new SimpleDateFormat("hh:mm:ss");

    int counter = 0;
    ServerSocketThread server;

    public void start(int port) {
        if (server != null && server.isAlive()) {
            System.out.println("Server already started " + port);
        } else {
            server = new ServerSocketThread(this, "Chat server " + counter++, port, SERVER_SOCKET_TIMEOUT);
        }
    }

    public void stop() {
        if (server == null || !server.isAlive()) {
            System.out.println("Server is not running");
        } else {
            server.interrupt();
        }
    }

    private void putLog(String msg) {
        msg = DATE_FORMAT.format(System.currentTimeMillis()) +
                Thread.currentThread().getName() + " :" + msg;
        System.out.println(msg);
    }

    @Override
    public void onServerStart(ServerSocketThread thread) {
        putLog("Server thread started");
    }

    @Override
    public void onServerStop(ServerSocketThread thread) {
        putLog("Server thread stopped");
    }

    @Override
    public void onServerSocketCreated(ServerSocketThread t, ServerSocket s) {
        putLog("Server thread created");
    }

    @Override
    public void onServerSoTimeout(ServerSocketThread t, ServerSocket s) {

    }

    @Override
    public void onSockedAccepted(ServerSocketThread t, ServerSocket s, Socket client) {
        putLog("client connected");
        String name = "SocketThread" + s.getInetAddress() + " :" + client.getPort();
        new SocketThread(this, name, client);
    }

    @Override
    public void onServerException(ServerSocketThread t, Throwable e) {
        e.printStackTrace();
    }
//SocketThreadListener

    @Override
    public void onSocketStart(SocketThread t, Socket s) {
        putLog("Client connected");
    }

    @Override
    public void onSocketStop(SocketThread t) {
        putLog("Client disconnected");
    }

    @Override
    public void onSocketReady(SocketThread t, Socket socket) {
        putLog("Client is ready");
    }

    @Override
    public void onReceiveString(SocketThread t, Socket s, String msg) {
        t.sendMessage("echo: " + msg);
    }

    @Override
    public void onSocketException(SocketThread t, Throwable e) {
        e.printStackTrace();
    }
}
