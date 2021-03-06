package Course2.Lessons.Lesson_5.Chat;

public class ServerSocketThread extends Thread {
    private int port;

    ServerSocketThread(String name, int port) {
        super(name);
        this.port = port;
        start();
    }

    @Override
    public void run() {
        System.out.println("Server started");
        while (!isInterrupted()) {
            System.out.println(getName() + " is running");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                interrupt();
            }
        }
        System.out.println("Server stopped");
    }
}
