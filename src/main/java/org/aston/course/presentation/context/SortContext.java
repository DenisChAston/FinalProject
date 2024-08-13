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

/**
 * Дополнителный контекст для работы с пользователем по сортировке вписка
 */

public class SortContext {

    /**
     * Метод для работы по сортировке. Принимает список, тип сортировки, список компараторов
     * @param list - кастомный список объектов
     * @param sortType - тип сортировки
     * @param reader - поток чтения
     * @param comparators - список компараторов
     * @param <T> - тип объекта
     * @throws IOException
     */
    public <T extends SomeEntity & Comparable<T>> void start(CustomList<T> list, Sort<T> sortType, BufferedReader reader, List<SomeComparator<T>> comparators) throws IOException {
        String userInput;

        while (true) {
            System.out.print("\n1.Сортировка\n" +
                               "2.Сортировка четных\n" +
                               "3.Сортировка нечетных\n" +
                               "4.Назад\n" +
                               "Выберете действие:");
            userInput = reader.readLine();
            switch (userInput) {
                case "1" -> {
                    //если список не остортирован, то запустить сортировку
                    if (!list.isListIsAlreadySort()) {
                        CustomUtils.sort(list, sortType);
                        //установить флаг сортировки в true
                        list.setListIsAlreadySort(true);
                        System.out.println("Сортировка выполнена");
                    }
                    return;
                }
                case "2" -> {
                    //сортировка, если значение параметра четное
                    CustomUtils.sort(list, sortType, comparators.get(0));
                    list.setListIsAlreadySort(false);
                    System.out.println("Сортировка выполнена");
                    return;
                }
                case "3" -> {
                    //сортировка, если значение параметра нечетное
                    CustomUtils.sort(list, sortType, comparators.get(1));
                    list.setListIsAlreadySort(false);
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
