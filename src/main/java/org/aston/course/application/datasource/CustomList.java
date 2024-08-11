package org.aston.course.application.datasource;

import java.util.ArrayList;
import java.util.List;

public class CustomList<E extends Comparable<E>> {


    private final List<E> list;
    private final int capacity;

    public CustomList(int capacity) {
        list = new ArrayList<>();
        this.capacity = capacity;
    }

    public int size() {
        return list.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public void set(int index, E e) {
        list.set(index, e);
    }

    public void add(E e) {
        list.add(e);
    }

    public E get(int index) {
        return list.get(index);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
