package Course2.Lessons.Lesson_3;


import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Exception {

    static class TestStream implements Closeable {
        TestStream(String name) throws FileNotFoundException {
            if (name.equals("error"))
                throw new FileNotFoundException("file not found");
            System.out.println("file opened");
        }

        void read() throws SQLException {
            throw new SQLException("read failed");
            //System.out.println("byte read");
        }

        @Override
        public void close() throws IOException {
            throw new IOException("failed to close!");
            //System.out.println("stream closed, resource released");
        }
    }

    public static void main(String[] args) {
        try (TestStream s = new TestStream("correct")) {
            s.read();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
