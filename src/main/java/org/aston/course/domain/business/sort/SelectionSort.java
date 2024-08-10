package org.aston.course.domain.business.sort;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.domain.model.SomeEntity;

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

    public static <T extends Comparable<T>> void sort(CustomList<T> list) {
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
}
