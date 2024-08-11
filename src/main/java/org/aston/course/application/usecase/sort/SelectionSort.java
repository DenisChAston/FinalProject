package org.aston.course.application.usecase.sort;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.domain.model.SomeEntity;
import org.aston.course.domain.model.Sort;

import java.util.Comparator;

public class SelectionSort<T extends Comparable<T> & SomeEntity> implements Sort<T> {

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
    @Override
    public void sort(CustomList<T> list) {
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

    @Override
    public void sort(CustomList<T> list, Comparator<T> comparator) {
        for (int i = 0; i < list.size(); i++) {
            int pos = i;
            T min = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                // Нужно чтобы здесь я мог вызывать один из трех методов для сравнения выбранного поля
                if (comparator.compare(list.get(j), min) < 0) {
                    pos = j;
                    min = list.get(j);
                }
            }
            list.set(pos, list.get(i));
            list.set(i, min);
        }
    }
}
