import java.util.Arrays;

public class lesson_01 {
    public static void main(String[] args) {

        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(isMyMethod(7, 35));
        isNumber(-100);
        System.out.println(isMyNumber(0));
        isMyMethod02("Hello, world!", 5);
        System.out.println(isMyYear(2025));
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        arrayMethod(arr);
        myArrayMethod(arr);
        updateMyArray(arr);
        myMatrix();
        int[] myArray = createArray(5, 100);
    }

    public static void printThreeWords() {
        System.out.println(" Orange, \n Banana, \n Apple ");
    }

    public static void checkSumSign() {
        int a = 1;
        int b = 2;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else if (a + b <= 0) {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 101;
        if (value < 0) {
            System.out.println("Красный");
        } else if (value > 0 && value < 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 504;
        int b = 500;
        if (a >= b) {
            System.out.println("a >= b");
        } else if (a <= b) {
            System.out.println("a < b");
        }
    }

    public static boolean isMyMethod(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    public static void isNumber(int number) {
        if (number >= 0) {
            System.out.println("Положительное число");
        } else if (number < 0) {
            System.out.println("Отрицательное число");
        }
    }

    public static boolean isMyNumber(int num) {
        return num < 0;
    }

    public static void isMyMethod02(String str, int times) {
        for (int i = 0; i < times; i++)
            System.out.println(str);
    }

    public static boolean isMyYear(int year) {
        return (year % 400 == 0) || (year % 100 != 0 && year % 4 != 0);
    }

    public static void arrayMethod(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? 1 : 0;
        }
        System.out.print("Изменённый массив: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void myArrayMethod(int[] arr) {
        int[] myArray = new int[100];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = i;
            System.out.println(myArray[i] + "");
        }
    }

    public static void updateMyArray(int[] arr) {
        int[] numbers = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 6) {
                numbers[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(numbers));
    }

    public static void myMatrix() {
        int n = 3;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) {
                    matrix[i][j] = 1;
                }
            }
        }
        System.out.println("Единицы по диагонали:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[] createArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        System.out.println("Создан массив: " + Arrays.toString(arr));
        return arr;

    }

}



