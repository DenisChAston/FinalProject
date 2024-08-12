package org.aston.course.application.usecase;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.domain.model.SomeEntity;
import org.aston.course.domain.business.Sort;

import java.util.Comparator;
import java.util.Optional;

/**
 * Кастомный класс с методами sort, sort с компаратором, бинарным поиском, выводом в консоль списка объектов
 */

public class CustomUtils {


    /**
     * Метод для сортировки списка с использованием конкретного типа сортировки
     * @param list - кастомный список объектов
     * @param sort - объект, определяющий тип сортировки
     * @param <T> - тип объекта
     */
    public static <T extends Comparable<T> & SomeEntity> void sort(CustomList<T> list, Sort<T> sort) {
        sort.sort(list);
    }

    /**
     * Метод для сортировки списка с использованием конкретного типа сортировки и компаратора
     * @param list - кастомный список объектов
     * @param sort - объект, определяющий тип сортировки
     * @param comparator - компаратор, определяющий правила сортировки
     * @param <T> - тип объекта
     */
    public static <T extends Comparable<T> & SomeEntity> void sort(CustomList<T> list, Sort<T> sort, Comparator<T> comparator) {
        sort.sort(list, comparator);
    }

    /**
     * Метод для бинарного поиска объекта
     * @param list - кастомный список объектов
     * @param desiredObject - искомый объект
     * @return - объект типа Optional
     * @param <T> - тип объекта
     */
    public static <T extends Comparable<T> & SomeEntity> Optional<T> binarySearch(CustomList<T> list, T desiredObject) {

        int min, max, mid;
        min = 0;
        max = list.size()-1;
        //если объект не будет найден, то Optional будет хранить null. Далее мы проверим, есть ли внутри него что-то, кроме null
        Optional<T> foundObject = Optional.empty();

        while(min <= max) {
            mid = min + (max - 1) / 2;
            int res = desiredObject.compareTo(list.get(mid));
            if (res == 0) {
                //если объект найден, то упаковываем его в объкт Optional
                foundObject = Optional.of(list.get(mid));
                break;
            } else if (res > 0) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return foundObject;
    }

    /**
     * Метод для печати объектов в консоль
     * @param list - кастомный список объектов
     * @param <T> - тип объекта
     */
    public static <T extends Comparable<T> & SomeEntity> void print(CustomList<T> list) {
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i+1 + ". ");
            System.out.println(list.get(i).toString());
        }
    }
}
