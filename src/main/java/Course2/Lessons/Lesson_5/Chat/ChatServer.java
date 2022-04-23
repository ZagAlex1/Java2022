package Course2.Lessons.Lesson_5.Chat;

public class ChatServer {
    int counter = 0;
    ServerSocketThread server;

    void start(int port) {
        if (server != null && server.isAlive()) {
            System.out.println("Server already started " + port);
        } else {
            server = new ServerSocketThread ("Chat server " + counter++, port);
        }
    }

    void stop() {
        if (server == null || !server.isAlive()) {
            System.out.println("Server is not running");
        } else {
            server.interrupt();
        }
    }
}
