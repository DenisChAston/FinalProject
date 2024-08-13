package org.aston.course.domain.business.sort;

import org.aston.course.application.datasource.Student;
import org.aston.course.domain.model.EvenOddCheck;
import org.aston.course.domain.model.SomeEntity;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

    public static <T extends SomeEntity<T>> void sort(List<T> list, Option option) {
        boolean hasEvenInterface;
        if (!list.isEmpty()) hasEvenInterface = checkEvenInterface(list.get(0));
        else return;
        for (int i = 0; i < list.size(); i++) {
            T entity = list.get(i);
            if (hasEvenInterface && checkOption((EvenOddCheck) entity, option)) continue;
            int pos = i;
            T min = list.get(pos);
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(min) < 0) {
                    pos = j;
                    min = list.get(j);
                }
            }
            if (hasEvenInterface && checkOption((EvenOddCheck) min, option)) continue;
            list.set(pos, list.get(i));
            list.set(i, min);
        }
    }

    private static <T extends SomeEntity<T>> boolean checkEvenInterface(T entity) {
        Class<?>[] interfaces = entity.getClass().getInterfaces();
        for (Class<?> anInterface : interfaces) {
            if (anInterface == EvenOddCheck.class) return true;
        }
        return false;
    }

    private static <T extends EvenOddCheck> boolean checkOption(T entity, Option option) {
        boolean isEven = entity.isEvenNumber();
        if (option == Option.ALL) return false;
        else if (option == Option.EVEN && isEven) return false;
        else return option != Option.ODD || isEven;
    }

    // закинул мейн для проверки. В первой пачке только нечетные, а во второй солянка.
    // далее проверка с классом User
    public static void main(String[] args) {
        Student student1 = new Student.StudentBuilder().setGroupNumber(9).build();
        Student student2 = new Student.StudentBuilder().setGroupNumber(1).build();
        Student student3 = new Student.StudentBuilder().setGroupNumber(3).build();
        Student student4 = new Student.StudentBuilder().setGroupNumber(5).build();
        Student student5 = new Student.StudentBuilder().setGroupNumber(7).build();
        Student student6 = new Student.StudentBuilder().setGroupNumber(5).build();

//        Student student1 = new Student.StudentBuilder().setGroupNumber(4).build();
//        Student student2 = new Student.StudentBuilder().setGroupNumber(2).build();
//        Student student3 = new Student.StudentBuilder().setGroupNumber(7).build();
//        Student student4 = new Student.StudentBuilder().setGroupNumber(6).build();
//        Student student5 = new Student.StudentBuilder().setGroupNumber(5).build();
//        Student student6 = new Student.StudentBuilder().setGroupNumber(8).build();

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
        sort(students, Option.EVEN);
//        sort(students, Option.ODD);
//        sort(students, Option.ALL);
        for (Student student : students) {
            System.out.println(student.getGroupNumber());
        }

//        User user1 = new User.UserBuilder().setName("Ivan").build();
//        User user2 = new User.UserBuilder().setName("Alex").build();
//        User user3 = new User.UserBuilder().setName("Sveta").build();
//
//        List<User> users = new ArrayList<>();
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//
//        for (User user : users) {
//            System.out.println(user.getName());
//        }
//        System.out.println("-----------");
//        sort(users, Option.EVEN);
//        for (User user : users) {
//            System.out.println(user.getName());
//        }

    }
}
