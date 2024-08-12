package org.aston.course.presentation.context;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.application.usecase.CustomUtils;
import org.aston.course.application.usecase.sort.SelectionSort;
import org.aston.course.domain.business.SomeComparator;
import org.aston.course.domain.business.Sort;
import org.aston.course.domain.model.SomeEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class SortContext {


    public <T extends SomeEntity & Comparable<T>> void start(CustomList<T> list, Sort<T> sortType, BufferedReader reader, List<SomeComparator<T>> comparators) throws IOException {
        String userInput;

        while (true) {
            System.out.println("\nВыберете действие:\n" +
                                        "1.Сортировка\n" +
                                        "2.Сортировка четных\n" +
                                        "3.Сортировка нечетных\n" +
                                        "4.Назад");
            userInput = reader.readLine();
            switch (userInput) {
                case "1" -> {
                    if (!list.isListIsAlreadySort()) {
                        CustomUtils.sort(list, sortType);
                        list.setListIsAlreadySort(true);
                        System.out.println("Сортировка выполнена");
                    }
                    return;
                }
                case "2" -> {
                    CustomUtils.sort(list, sortType, comparators.get(0));
                    System.out.println("Сортировка выполнена");
                    return;
                }
                case "3" -> {
                    CustomUtils.sort(list, sortType, comparators.get(1));
                    System.out.println("Сортировка выполнена");
                    return;
                }
                case "4" -> {
                    return;
                }
                default -> System.out.println("Введите цифру в диапазоне!");
            }
        }
    }
}
