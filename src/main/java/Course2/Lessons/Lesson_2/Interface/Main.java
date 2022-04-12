package Course2.Lessons.Lesson_2.Interface;

public class Main {

    private interface Animal {
        void breath();

        void look();
    }

    private interface Human extends Animal {
        void talk();

        default void walk() {
            System.out.println("walk on legs");
        }
    }

    private interface Bull extends Animal {
        default void walk() {
            System.out.println("walk on hooves");
        }

        void voice();
    }

    private static class Minotaur implements Human, Bull {
        @Override
        public void breath() {

        }

        @Override
        public void look() {

        }

        @Override
        public void talk() {

        }

        @Override
        public void walk() {
            Human.super.walk();
        }

        @Override
        public void voice() {

        }
    }

    private static class Man implements Human {

        @Override
        public void breath() {

        }

        @Override
        public void look() {

        }

        @Override
        public void talk() {

        }

        @Override
        public void walk() {

        }
    }

    private static void addMouseListener(MouseListener l) {
    }

    private interface MouseListener {
        void mouseUp();
    }

    private static void addKeyboardListener(KeyboardListener k) {
    }

    private interface KeyboardListener {
        void KeyPressed(String key);
    }

    private static class DivisionByZeroException extends Exception {
        DivisionByZeroException(String s) {
            super(s);
        }
    }

    private static int countCoefficient() throws DivisionByZeroException {
        try {
            div(1, 0);
        } catch (DivisionByZeroException e) {
            return 5;
        }
        return div(1, 0);
    }
    private static int div(int a, int b) throws DivisionByZeroException {
        if (b == 0) {
            //System.out.println("bad denominator");
            // return 0;
            throw new DivisionByZeroException("bad denominator");
        }
        return a / b;
    }


    public static void main(String[] args) {
        System.out.println("here we start");
        try {
            countCoefficient();
        //    div(10, 0);
        } catch (DivisionByZeroException e) {
            System.out.println("exception happened");
        }
        System.out.println("Here we continue");

        addKeyboardListener((key) -> {
            System.out.println(key);
        });

        class ML implements MouseListener {
            @Override
            public void mouseUp() {

            }
        }
        ML listener = new ML();
        addMouseListener(listener);
        addMouseListener(new ML());
        addMouseListener(new MouseListener() {
            @Override
            public void mouseUp() {
            }
        });
        addMouseListener(() -> {
        });


        Bull ivan = new Minotaur();
        ivan.walk();
    }
}
