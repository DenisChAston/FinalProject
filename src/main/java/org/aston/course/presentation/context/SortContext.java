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
import java.util.List;

public class SortContext {


    public <T extends SomeEntity & Comparable<T>> void start(CustomList<T> list, Sort<T> sortType, BufferedReader reader, List<SomeComparator<T>> comparators) throws IOException {
        boolean isBack = false;
        String userInput = "";

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
                    CustomUtils.sort(list, new SelectionSort<>(), comparators.get(0));
                }
                case "3" -> {
                    System.out.println("Сортировка нечетных");
                    CustomUtils.sort(list, new SelectionSort<>(), comparators.get(1));
                }
                case "4" -> {
                    isBack = true;
                }
                default -> System.out.println("Введите цифру в диапазоне!");
            }
        }
    }
}
