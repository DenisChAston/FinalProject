package org.aston.course.presentation.context;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.application.usecase.CustomUtils;
import org.aston.course.application.usecase.sort.SelectionSort;
import org.aston.course.domain.business.EntityCreator;
import org.aston.course.domain.business.SomeComparator;
import org.aston.course.domain.model.SomeEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class MainContext {

    public <T extends Comparable<T> & SomeEntity> boolean start(EntityCreator<T> entityCreator, LoadStrategy loadStrategy, BufferedReader reader,
                                                                int listCapacity, List<SomeComparator<T>> comparators) throws IOException {

        boolean isBack = false;
        boolean isExit = false;
        String userInput = "";
        CustomList<T> list = new CustomList<>(listCapacity);
        loadStrategy.load(list, entityCreator);

        while (!isBack) {
            System.out.println("\nВыберете действие:\n1.Сортировка\n2.Поиск объекта\n3.Печать списка\n4.Назад\n5.Выход");
            userInput = reader.readLine();
            switch (userInput) {
                case "1" -> {
                    new SortContext().start(list, new SelectionSort<>(), reader, comparators);
                }
                case "2" -> {
                    if (!list.isListIsAlreadySort()) {
                        CustomUtils.sort(list, new SelectionSort<>());
                        System.out.println("Выполнена сортировка");
                    }
                    //list.binarySearch();
                    //сделать вызов метода поиска;
                }
                case "3" -> {
                    CustomUtils.print(list);
                    //вызов метода печати списка
                }
                case "4" -> {
                    isBack = true;
                }
                case "5" -> {
                    isBack = true;
                    isExit = true;
                }
                default -> System.out.println("Введите цифру в диапазоне!");
            }
        }
        return isExit;
    }
}



