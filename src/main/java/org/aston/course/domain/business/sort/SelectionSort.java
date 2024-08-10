package org.aston.course.domain.business.sort;

import org.aston.course.application.datasource.Student;
import org.aston.course.domain.model.SomeEntity;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

    public static <T extends SomeEntity<T>> void sort(List<T> list, Option option) {
        for (int i = 0; i < list.size(); i++) {
            int pos = i;
            T min = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(min) < 0) {
                    pos = j;
                    min = list.get(j);
                }
            }
            if(!checkOption(min.isEvenNumber(), option)) continue;
            list.set(pos, list.get(i));
            list.set(i, min);
        }
    }

    private static boolean checkOption(boolean isEven, Option option) {
        if(option == Option.ALL) return true;
        else if(option == Option.EVEN && isEven) return true;
        else return option == Option.ODD && !isEven;
    }

    // закинул мейн для проверки. В первой пачке только нечетные, а во второй солянка.
    public static void main(String[] args) {
//        Student student1 = new Student.StudentBuilder().setGroupNumber(9).build();
//        Student student2 = new Student.StudentBuilder().setGroupNumber(1).build();
//        Student student3 = new Student.StudentBuilder().setGroupNumber(3).build();
//        Student student4 = new Student.StudentBuilder().setGroupNumber(5).build();
//        Student student5 = new Student.StudentBuilder().setGroupNumber(7).build();
//        Student student6 = new Student.StudentBuilder().setGroupNumber(5).build();

        Student student1 = new Student.StudentBuilder().setGroupNumber(2).build();
        Student student2 = new Student.StudentBuilder().setGroupNumber(1).build();
        Student student3 = new Student.StudentBuilder().setGroupNumber(7).build();
        Student student4 = new Student.StudentBuilder().setGroupNumber(6).build();
        Student student5 = new Student.StudentBuilder().setGroupNumber(9).build();
        Student student6 = new Student.StudentBuilder().setGroupNumber(8).build();

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);

        for (Student student : students) {
            System.out.println(student.getGroupNumber());
        }
        System.out.println("----------------------------");
//        sort(students, Option.EVEN);
//        sort(students, Option.ODD);
        sort(students, Option.ALL);
        for (Student student : students) {
            System.out.println(student.getGroupNumber());
        }
    }
}
