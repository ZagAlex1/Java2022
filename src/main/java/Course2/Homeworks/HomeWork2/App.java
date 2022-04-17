package Course2.Homeworks.HomeWork2;

public class App {

    public static void parseArray(String[][] arr) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    Integer.parseInt(arr[i][j]);
                    sum += Integer.parseInt(arr[i][j]);
                } catch (RuntimeException e) {
                    throw new MyArrayDataException("Не число " + " в ячейке " + i + j);
                }
            }
        }
        System.out.println("Сумма элементов " + sum);
        printArray(arr);
    }

    public static String[][] strArray(int row, int tab) throws MyArraySizeException {
        String[][] array = new String[row][tab];
        if (row > 4 || tab > 4) {
            throw new MyArraySizeException("Wrong size");
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = "11";
            }
        }
        return array;
    }

    public static void printArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        try {
            parseArray(strArray(4, 4));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

}