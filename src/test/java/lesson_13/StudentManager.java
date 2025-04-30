package lesson_13;

import java.util.Iterator;
import java.util.Set;

public class StudentManager {
    public static void removeStudent(Set<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3.0) {
                iterator.remove();
                System.out.println("Удален студент: " + student.getName() + ", Средний бал: " + student.getAverageGrade());
            }
        }
    }

    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3.0) {
                System.out.println("Студент " + student.getName() + " переведен с курса " + student.getCourse() + " на курс " + (student.getCourse() + 1));
                student.nextCourse();
            }
        }
    }

    public static void printStudents(Set<Student> students, int cource) {
        System.out.println("Студенты " + cource + " курса: ");
        for (Student student : students) {
            if (student.getCourse() == cource) {
                System.out.println(student.getName() + "," + student.getGroup() + ", средний балл: " + student.getAverageGrade());
            }
        }
    }
}