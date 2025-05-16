package lesson_13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory {
    private Map<String, List<String>> directory;

    public PhoneDirectory() {
        directory = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        if (!directory.containsKey(lastName)) {
            directory.put(lastName, new ArrayList<>());
        }
        directory.get(lastName).add(phoneNumber);
    }

    public List<String> get(String lastName) {
        return directory.get(lastName);
    }

    public void printNumbers(String lastName) {
        List<String> numbers = this.get(lastName);
        if (numbers != null) {
            System.out.println("Номера " + lastName + " : " + numbers);
        } else {
            System.out.println(lastName + " не найден");
        }
    }

    public void printAll() {
        for (Map.Entry<String, List<String>> entry : directory.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }
    }
}