package org.aston.course.application.usecase;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.domain.model.SomeEntity;
import org.aston.course.domain.business.Sort;

import java.util.Comparator;
import java.util.Optional;

public class CustomUtils {

    public static <T extends Comparable<T> & SomeEntity> void sort(CustomList<T> customList, Sort<T> sort) {
        sort.sort(customList);
    }

    public static <T extends Comparable<T> & SomeEntity> void sort(CustomList<T> customList, Sort<T> sort, Comparator<T> comparator) {
        sort.sort(customList, comparator);
    }

    public static <T extends Comparable<T> & SomeEntity> Optional<T> binarySearch(CustomList<T> customList, T desiredObject) {

        int min, max, mid;
        min = 0;
        max = customList.size()-1;
        Optional<T> foundObject = Optional.empty();

        while(min <= max) {
            mid = min + (max - 1) / 2;
            int res = desiredObject.compareTo(customList.get(mid));
            if (res == 0) {
                foundObject = Optional.of(customList.get(mid));
                break;
            } else if (res > 0) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return foundObject;
    }

    public static <T extends Comparable<T> & SomeEntity> void print(CustomList<T> customList) {
        System.out.println();
        for (int i = 0; i < customList.size(); i++) {
            System.out.print(i+1 + ". ");
            System.out.println(customList.get(i).toString());
        }
    }
}
