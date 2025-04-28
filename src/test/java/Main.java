public class Main {
    public static void main(String[] args) {
        ArrayProcessor processor = new ArrayProcessor();

        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "семь", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"},
                {"10", "11", "12"}
        };
        try {
            System.out.println("Сумма correctArray: " + processor.processArray(correctArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            System.out.println("Сумма invalidDataArray: " + processor.processArray(invalidDataArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            System.out.println("Сумма wrongSizeArray: " + processor.processArray(wrongSizeArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        processor.demonstrateIndexOutOfBounds();
    }
}