public class lesson_12 {
    static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    static class MyArrayDataException extends Exception {
        private final int row;
        private final int col;
        private final String value;

        public MyArrayDataException(int row, int col, String value) {
            super(String.format("Неверные данные в ячейке [%d][%d]: '%s'", row, col, value));
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    public static class ArrayProcessor {
        public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
            if (array.length != 4) {
                throw new MyArraySizeException("Массив должен иметь 4 строки");
            }
            for (String[] row : array) {
                if (row.length != 4) {
                    throw new MyArraySizeException("Каждая строка массива должна содержать 4 элемента");
                }
            }
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    try {
                        sum += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i, j, array[i][j]);
                    }
                }
            }
            return sum;
        }

        public static void demonstrateIndexOutOfBounds() {
            try {
                int[] arr = new int[5];
                System.out.println(arr[10]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Ошибка: индекс 10 недопустим для массива длиной 5");
            }
        }
    }
}
