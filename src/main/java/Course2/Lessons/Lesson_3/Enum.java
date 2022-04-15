package Course2.Lessons.Lesson_3;

public class Enum {

    enum Color {
        RED("#FF0000"), BLUE("#0000FF"), GREEN("#00FF00");
        private String code;
        Color(String code) {
            this.code = code;
        }
        public String getCode() {
            return code;
        }


    }

    public static void main(String[] args) {
        System.out.println(Color.BLUE);
        System.out.println(Color.GREEN == Color.RED);
        System.out.println(Color.RED.getCode());
        Color[] colors = Color.values();
        for (Color color : colors) {
            System.out.println(color);
        }
    }
}
