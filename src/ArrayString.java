import java.util.Arrays;
import Exception.*;

public class ArrayString {
    public static void main(String[] args) {
        String strSource = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String[][] arrStrSource = new String[4][4];
        int sum = 0;
        int num = 300;

        try {
            arrStr(strSource, arrStrSource);
            System.out.println("String\n" + strSource + "\nconverted to a two-dimensional array " +
                    Arrays.deepToString(arrStrSource));
        } catch (IndexOutOfBoundsException e) {
            e.getStackTrace();
            System.out.println("Индекс массива выходит за пределы массива");
        }

        try {
            sum = getSum(arrStrSource, sum, num);
            System.out.println("Amount/2 = " + sum + "/2 " + sum / 2);
        } catch (IndexOutOfBoundsException e) {
            e.getStackTrace();
            System.out.println("Индекс массива выходит за пределы массива");
        } catch (NumberFormatException e) {
            e.getStackTrace();
            System.out.println("Элементы массива на преобработаны в число");
        } catch (IsNumberException e){
            e.getStackTrace();
            System.out.println("Отловили число " + num);
        }
    }

    private static int getSum(String[][] arrStrSource, int sum, int num)
            throws IndexOutOfBoundsException, NumberFormatException, IsNumberException {
        for (int i = 0; i < arrStrSource.length; i++) {
            for (int j = 0; j < arrStrSource[i].length; j++) {
                if (Integer.parseInt(arrStrSource[i][j]) == num) {
                    throw new IsNumberException(num);
                }
                sum += Integer.parseInt(arrStrSource[i][j]);
            }
        }
        return sum;
    }

    private static void arrStr(String strSource, String[][] arrStrSource)
            throws IndexOutOfBoundsException {
        String[] arr;
        arr = strSource.split("\n");

        for (int i = 0; i < arr.length; i++) {
            arrStrSource[i] = arr[i].split(" ");
        }
    }
}
