package org.aston.course.presentation.context;

import org.aston.course.application.datasource.Bus;
import org.aston.course.application.datasource.CustomList;
import org.aston.course.application.datasource.Student;
import org.aston.course.application.usecase.CustomUtils;
import org.aston.course.application.usecase.comparators.BussEvenNumberComparatorImpl;
import org.aston.course.application.usecase.comparators.StudentEvenBussComparatorImpl;
import org.aston.course.application.usecase.sort.SelectionSort;
import org.aston.course.domain.business.SomeComparator;
import org.aston.course.domain.business.Sort;
import org.aston.course.domain.model.SomeEntity;

import java.io.BufferedReader;
import java.io.IOException;

public class SortContext {


    public <T extends SomeEntity & Comparable<T>> void start(CustomList<T> list, Sort<T> sortType, BufferedReader reader) throws IOException {
        boolean isBack = false;
        String userInput = "";
        SomeComparator<T> comparator = null;

        while (!isBack) {
            System.out.println("\nВыберете действие:\n1.Сортировка\n2.Сортировка четных\n3.Сортировка нечетных\n4.Назад");
            userInput = reader.readLine();
            switch (userInput) {
                case "1" -> {
                    CustomUtils.sort(list, new SelectionSort<>());
                    list.setListIsAlreadySort(true);
                    System.out.println("Сортировка выполнена");
                }
                case "2" -> {
                    System.out.println("Сортировка четных");
                    comparator = getEvenNumberComparator(list);
                    CustomUtils.sort(list, new SelectionSort<>(), comparator);
                }
                case "3" -> {
                    System.out.println("Сортировка нечетных");
                    //CustomUtils.sort(list, new SelectionSort<>());
                }
                case "4" -> {
                    isBack = true;
                }
                default -> System.out.println("Введите цифру в диапазоне!");
            }
        }
    }


    public <T extends SomeEntity & Comparable<T>> SomeComparator<T> getEvenNumberComparator(CustomList<T> list) {
        SomeComparator<T> someComparator = null;
        if (list.size() != 0) {
            if (list.get(0) instanceof Bus)
                someComparator = (SomeComparator<T>) new BussEvenNumberComparatorImpl();
            else if (list.get(0) instanceof Student)
                someComparator = (SomeComparator<T>) new StudentEvenBussComparatorImpl();
        }
        return someComparator;
    }
}
