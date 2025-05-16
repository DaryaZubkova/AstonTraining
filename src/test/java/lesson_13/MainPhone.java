package lesson_13;

public class MainPhone {
    public static void main(String[] ergs) {
        PhoneDirectory phoneBook = new PhoneDirectory();

        phoneBook.add("Сидорова", "8-123-456-78-90");
        phoneBook.add("Петров", "8-345-678-90-12");
        phoneBook.add("Иванов", "8-456-789-01-23");
        phoneBook.add("Сидорова", "8-098-765-43-21");

        phoneBook.printNumbers("Сидорова");
        phoneBook.printNumbers("Петрова");
        phoneBook.printNumbers("Иванов");

        phoneBook.printAll();
    }
}