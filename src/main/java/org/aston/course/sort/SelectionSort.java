package org.aston.course.sort;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

//    public static <T extends Comparable<T>> void sort(List<T> list, String paramName) throws NoSuchFieldException {
//        for (int i = 0; i < list.size(); i++) {
//            Field field = list.get(i).getClass().getDeclaredField(paramName);
//            int pos = i;
//            T min = list.get(i);
//            for (int j = i + 1; j < list.size(); j++) {
//                if (list.get(j).compareTo(min) < 0) {
//                    pos = j;
//                    min = list.get(j);
//                }
//            }
//            list.set(pos, list.get(i));
//            list.set(i, min);
//        }
//    }

    public static <T extends Comparable<T>> void sort(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            int pos = i;
            T min = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                // Нужно чтобы здесь я мог вызывать один из трех методов для сравнения выбранного поля
                if (list.get(j).compareTo(min) < 0) {
                    pos = j;
                    min = list.get(j);
                }
            }
            list.set(pos, list.get(i));
            list.set(i, min);
        }
    }


    public static void main(String[] args) {

        Student student1 = new Student(3, 0, 0);
        Student student2 = new Student(1, 0, 0);
        Student student3 = new Student(2, 0, 0);
        Student student4 = new Student(4, 0, 0);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        System.out.println(students);
        sort(students);
        System.out.println(students);
    }

}
