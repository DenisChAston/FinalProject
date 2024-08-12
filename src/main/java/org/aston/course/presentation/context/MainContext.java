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
import java.util.Optional;

public class MainContext {

    public <T extends Comparable<T> & SomeEntity> boolean start(EntityCreator<T> entityCreator, LoadStrategy loadStrategy, BufferedReader reader,
                                                                int listCapacity, List<SomeComparator<T>> comparators) throws IOException {

        String userInput;
        CustomList<T> list = new CustomList<>(listCapacity);
        loadStrategy.load(list, entityCreator);

        while (true) {
            System.out.print("\n1.Сортировка\n" +
                             "2.Поиск объекта\n" +
                             "3.Печать списка\n" +
                             "4.Назад\n" +
                             "5.Выход\n" +
                             "Выберете действие: ");
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
                    BinarySearchContext binarySearchContext = new BinarySearchContext();
                    Optional<T> someEntity = binarySearchContext.start(list, entityCreator, reader);
                    T foundObject = null;
                    if (someEntity.isPresent()) {
                        foundObject = someEntity.get();
                    } else {
                        System.out.println("Объект не найден");
                    }
                }
                case "3" -> {
                    CustomUtils.print(list);
                }
                case "4" -> {
                    return false;
                }
                case "5" -> {
                    return true;
                }
                default -> System.out.println("Введите цифру в диапазоне!");
            }
        }
    }
}



