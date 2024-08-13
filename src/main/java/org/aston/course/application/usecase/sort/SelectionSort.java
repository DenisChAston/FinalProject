package org.aston.course.application.usecase.sort;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.domain.model.SomeEntity;
import org.aston.course.domain.business.Sort;

import java.util.Comparator;

/**
 *
 * @param <T>
 */

public class SelectionSort<T extends Comparable<T> & SomeEntity> implements Sort<T> {

    /**
     * Алгоритм сортировки выбором.
     * @param list - объект кастомного листа
     */
    @Override
    public void sort(CustomList<T> list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            int pos = i;
            T min = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(min) < 0) {
                    pos = j;
                    min = list.get(j);
                }
            }
            list.set(pos, list.get(i));
            list.set(i, min);
        }
        long finish = System.currentTimeMillis();
        System.out.println(finish-start);
    }

    /**
     * Алгоритм сортировки выбором с применением компаратора
     * @param list - объект кастомного листа
     * @param comparator - объект конкретного компаратора
     */
    @Override
    public void sort(CustomList<T> list, Comparator<T> comparator) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            int pos = i;
            T min = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(j), min) < 0) {
                    pos = j;
                    min = list.get(j);
                }
            }
            list.set(pos, list.get(i));
            list.set(i, min);
        }
        long finish = System.currentTimeMillis();
        System.out.println(finish-start);
    }
}
