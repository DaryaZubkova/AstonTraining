package lesson_13;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        Student student1 = new Student("Иван Иванов", "Группа 101", 1);
        student1.addGrade("Математика", 5);
        student1.addGrade("Русский", 5);
        student1.addGrade("Литература", 5);

        Student student2 = new Student("Денис Сидоров", "Группа 201", 2);
        student2.addGrade("Математика", 2);
        student2.addGrade("Русский", 3);
        student2.addGrade("Литература", 3);

        Student student3 = new Student("Вася Пупкин", "Группа 301", 1);
        student3.addGrade("Математика", 3);
        student3.addGrade("Русский", 4);
        student3.addGrade("Литература", 5);

        students.add(student1);
        students.add(student2);
        students.add(student3);

        System.out.println("Все студенты: ");
        for (Student student : students) {
            System.out.println(student);
        }

        StudentManager.removeStudent(students);

        StudentManager.promoteStudents(students);

        StudentManager.printStudents(students, 1);
        StudentManager.printStudents(students, 2);
    }
}