package org.aston.course.application.datasource;

import org.aston.course.domain.model.SomeEntity;

import java.util.ArrayList;
import java.util.List;

public class CustomList<E extends Comparable<E> & SomeEntity> {

    /**
     * Кастомный список объектов. Параметризирован объектами, унаследованными от
     * интерфейса SomeEntity и Comparable
     */

    /*
    Внутри используется обычный список. Можно адаптировать под массив
     */
    private final List<E> list;
    private final int capacity;

    //флаг для определения того, был ли отсортирован список
    private boolean listIsAlreadySort;

    /*
    Устанавливается параметр Capacity - вестимость списка
     */
    public CustomList(int capacity) {
        list = new ArrayList<>();
        this.capacity = capacity;
    }

    /*
    Переобределены стандартные методы списка List, для перенаправления действия
     */

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

    public boolean isListIsAlreadySort() {
        return listIsAlreadySort;
    }

    public void setListIsAlreadySort(boolean listIsAlreadySort) {
        this.listIsAlreadySort = listIsAlreadySort;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
