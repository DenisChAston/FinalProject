package org.aston.course.application.datasource;

import org.aston.course.domain.model.SomeEntity;

import java.util.AbstractList;
import java.util.Arrays;

public class CustomList<E extends Comparable<E> & SomeEntity> extends AbstractList<E> {

    /**
     * Кастомный список объектов. Параметризирован объектами, унаследованными от
     * интерфейса SomeEntity и Comparable
     */

    /*
    Внутри используется обычный список. Можно адаптировать под массив
     */
    private Object[] array;
    private final int capacity;
    private int size = 0;

    //флаг для определения того, был ли отсортирован список
    private boolean listIsAlreadySort;

    /*
    Устанавливается параметр Capacity - вестимость списка
     */
    public CustomList(int capacity) {
        array = new Object[capacity];
        this.capacity = capacity;
    }

    /*
    Переобределены стандартные методы списка List, для перенаправления действия
     */

    public int size() {
        return size;
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        return (E) array[index];
    }

    public int getCapacity() {
        return capacity;
    }

    //set

    @Override
    public E set(int index, E element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        array[index] = element;
        return element;
    }

    @Override
    public boolean add(E e) {
        set(size(), e);
        size++;
        return true;
    }

/*    public void add(int index, E e) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        ensureCapacity();
        for (int i = size - 1; i >= index ; i--) {
            array[i+1] = array[i];
        }
        array[index] = e;
        size++;
    }*/

    private void ensureCapacity() {
        int newSize = array.length * 2;
        array = Arrays.copyOf(array, newSize);
    }

/*    public void optimizeCapacity() {
        if (size() < getCapacity()) {
            int newCapacity = size();
            array = Arrays.copyOf(array, newCapacity);
        }
    }*/

    public boolean isListIsAlreadySort() {
        return listIsAlreadySort;
    }

    public void setListIsAlreadySort(boolean listIsAlreadySort) {
        this.listIsAlreadySort = listIsAlreadySort;
    }

    @Override
    public String toString() {
        return array.toString();
    }
}
