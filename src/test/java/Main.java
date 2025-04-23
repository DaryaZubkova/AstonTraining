public class Main {
    public static void main(String[] args) {
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
            System.out.println("Сумма correctArray: " + lesson_12.ArrayProcessor.processArray(correctArray));
        } catch (lesson_12.MyArraySizeException | lesson_12.MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            System.out.println("Сумма invalidDataArray: " + lesson_12.ArrayProcessor.processArray(invalidDataArray));
        } catch (lesson_12.MyArraySizeException | lesson_12.MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            System.out.println("Сумма wrongSizeArray: " + lesson_12.ArrayProcessor.processArray(wrongSizeArray));
        } catch (lesson_12.MyArraySizeException | lesson_12.MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        lesson_12.ArrayProcessor.demonstrateIndexOutOfBounds();
    }
}
