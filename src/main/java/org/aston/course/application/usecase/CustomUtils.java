package org.aston.course.application.usecase;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.domain.model.Sort;

import java.util.Comparator;

public class CustomUtils {

    public static <T extends Comparable<T>> void sort(CustomList<T> customList, Sort<T> sort) {
        sort.sort(customList);
    }

    public static <T extends Comparable<T>> void sort(CustomList<T> customList, Sort<T> sort, Comparator<T> comparator) {
        //sort.sort(customList, comparator);
    }

    public static <T extends Comparable<T>> int binarySearch(CustomList<T> customList, T t) {
        return -1;
    }

    public static <T extends Comparable<T>> void print(CustomList<T> customList) {
        for (int i = 0; i < customList.size(); i++) {
            System.out.print(i+1 + ". ");
            System.out.println(customList.get(i).toString());
        }
    }
}
