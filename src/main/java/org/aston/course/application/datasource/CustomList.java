package org.aston.course.application.datasource;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {


    private final List<T> list;
    private int size;

    public CustomList(int size) {
        list = new ArrayList<>();
        this.size = size;
    }

    public int size() {
        return size;
    }

    public void set(int index, T e) {
        list.set(index, e);
    }

    public void add(T e) {
        list.add(e);
        size = list.size();
    }

    public T get(int index) {
        return list.get(index);
    }

    @Override
    public String toString() {
        return list.toString();
    }

    /*    public void sort() {
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

    }*/


}
