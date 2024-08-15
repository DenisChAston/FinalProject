package org.aston.course.presentation.context;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.application.usecase.ConsoleReaderImpl;
import org.aston.course.application.usecase.CustomUtils;
import org.aston.course.domain.business.EntityCreator;
import org.aston.course.domain.model.SomeEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;

/**
 * Дополнительный контекст для работы с пользователем для бинарного поиска
 */
public class BinarySearchContext {

    /**
     * Метод для начала бинарного поиска.
     * В методе создается объект для работы с пользователем через консоль
     * Вызывается метод, который возвращает объект Optional,
     * в который либо упакован искомый объект, либо пустое значение
     * Вызывается метод бинарного поиска
     * @param list - отсортированный кастомный список
     * @param creator - объект, отвечающий за создание конкретного объекта
     * @param reader - поток чтения
     * @return - объект типа Optional
     * @param <T> - тип объекта
     * @throws IOException
     */
    public <T extends SomeEntity & Comparable<T>> Optional<T> start(CustomList<T> list, EntityCreator<T> creator, BufferedReader reader) throws IOException {

        ConsoleReaderImpl consoleReader = new ConsoleReaderImpl();
        Optional<T> obj = consoleReader.getObjectFromConsole(creator, reader, 1);
        if (obj.isPresent()){
            return CustomUtils.binarySearch(list, obj.get());
        }
        return obj;

/*        System.out.printf("Введите %s: ", creator.getFirstParamName());
        String firstParam = reader.readLine();
        System.out.printf("Введите %s: ", creator.getSecondParamName());
        String secondParam = reader.readLine();
        System.out.printf("Введите %s: ", creator.getThirdParamName());
        String thirdParam = reader.readLine();
        T tempEntity = creator.create(firstParam, secondParam, thirdParam);*/


    }
}
