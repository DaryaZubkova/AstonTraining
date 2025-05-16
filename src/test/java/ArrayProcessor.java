public class ArrayProcessor {
    public int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
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

    public void demonstrateIndexOutOfBounds() {
        try {
            int[] arr = new int[5];
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: индекс 10 недопустим для массива длиной 5");
        }
    }
}