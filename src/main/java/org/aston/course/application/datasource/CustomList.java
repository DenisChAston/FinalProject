package org.aston.course.application.datasource;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {


    private final List<T> list;

    public CustomList() {
        list = new ArrayList<>();
    }

    public void sort() {
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

    public void binarySearch(T entity) {

    }

    public void add(T entity) {
        list.add(entity);
    }
}
