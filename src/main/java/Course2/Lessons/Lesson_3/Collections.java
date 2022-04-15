package Course2.Lessons.Lesson_3;

import java.util.*;

public class Collections {

    static class Box implements Comparable{
        int width;
        int height;
        int num;
        Box( int width, int height, int num) {
            this.width = width;
            this.height = height;
            this.num = num;
        }

        @Override
        public String toString() {
            return String.format("Box(%d, %d (%d)", width, height, num);}

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if ( !(obj instanceof Box)) return false;
            Box other = (Box) obj;
            return width == other.width && height == other.height;
        }
        @Override
        public int hashCode() {return Objects.hash(width, height);}

        private int square() {return width * height;}

        @Override
        public int compareTo(Object o) {
            /*Box other = (Box) o;
            int sq = square();
            int oSq = other.square();
            if (sq < oSq) return -1;
            else if (sq > oSq) return 1;
            else return 0;*/
            return square() - ((Box) o).square();
        }
    }

    public static void main(String[] args) {

        String s0 = "he";
        String s1 = s0 + "llo";
        ArrayList<String> worlds = new ArrayList<>(Arrays.asList("hello", "world"));
        System.out.println(worlds.contains(s1));
        System.out.println();

        Box b = new Box(1,2, 1);
        Box[] boxes ={new Box(1,2,2), new Box(1,3,3), new Box(1,4,4), new Box(1,5,5)};

        List<Box> array = new LinkedList<>(Arrays.asList(boxes));
        System.out.println(array);
        System.out.println();

        System.out.println(array.contains(b));
        /*for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }*/
        /*Iterator<Box> iter= array.iterator();
        while (iter.hasNext()) {
            Box b = iter.next();
            System.out.println(b);
        }

        for (Box box : array) {
            System.out.println(box);
        }*/
        System.out.println(b.equals(array.get(0)));
        System.out.println(Integer.toHexString(b.hashCode()));
        System.out.println(Integer.toHexString(array.get(0).hashCode()));

        Set<Box> set = new LinkedHashSet<>(Arrays.asList(boxes));
        System.out.println(set);
        set.add(b);
        System.out.println(set);

        TreeSet<Box> tree = new TreeSet<>(Arrays.asList(boxes));
        System.out.println(tree);

        Map<String, Integer> months = new HashMap<>();
        months.put("January", 1);
        months.put("February", 2);
        months.put("March", 3);
        months.put("April", 4);
        System.out.println(months);
        months.put("January", 10);
        System.out.println(months);

        Set<String> s = months.keySet();
        for (String k : s) {
            System.out.printf("%s:%d ", k, months.get(k));
        }


    }
}
