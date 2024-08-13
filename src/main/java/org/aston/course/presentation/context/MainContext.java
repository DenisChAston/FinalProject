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

/**
 * Основной контекст для работы с пользователем
 */

public class MainContext {

    /**
     * Метод для работы с пользователем
     * @param entityCreator - объект, отвечающий за создание конкретного объекта
     * @param loadStrategy - стратегия создания объекта
     * @param reader - поток чтения
     * @param listCapacity - необходимая длина списка
     * @param comparators - список компараторов для конкретного объекта
     * @return - флаг завершения программы
     * @param <T> - тип объекта
     * @throws IOException
     */
    public <T extends Comparable<T> & SomeEntity> boolean start(EntityCreator<T> entityCreator, LoadStrategy loadStrategy, BufferedReader reader,
                                                                int listCapacity, List<SomeComparator<T>> comparators) throws IOException {

        String userInput;
        CustomList<T> list = new CustomList<>(listCapacity);

        loadStrategy.load(list, entityCreator, reader);
        if (list.size() == 0) {
            System.out.println("Список пустой!");
            return false;
        }

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
                    //новый контекст для работы с пользователем по сортировке
                    new SortContext().start(list, new SelectionSort<>(), reader, comparators);
                }
                case "2" -> {
                    //если список не осортирован, то сортируем его
                    if (!list.isListIsAlreadySort()) {
                        CustomUtils.sort(list, new SelectionSort<>());
                        list.setListIsAlreadySort(true);
                        System.out.println("Выполнена сортировка");
                    }
                    //и только потом создавать новый контекст для работы с пользователем по поиску объекта
                    BinarySearchContext binarySearchContext = new BinarySearchContext();
                    //возвращается объект Optional, который либо пустой внутри, либо содержит искомый объект
                    Optional<T> resultEntity = binarySearchContext.start(list, entityCreator, reader);
                    T foundObject;
                    //если он не пустой внутри, то достаем искомый объект
                    if (resultEntity.isPresent()) {
                        foundObject = resultEntity.get();
                        System.out.println("Найден объект - " + foundObject);
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



