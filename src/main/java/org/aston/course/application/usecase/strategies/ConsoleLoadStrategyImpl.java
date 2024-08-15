package org.aston.course.application.usecase.strategies;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.application.usecase.ConsoleReaderImpl;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.domain.business.EntityCreator;
import org.aston.course.domain.model.SomeEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;

/**
 * Сратегия заполнения списка объектами через консоль
 */

public class ConsoleLoadStrategyImpl implements LoadStrategy {


    /**
     * Метод заполнения списка объектами через консоль. Создается объект для работы с пользователем через консоль
     * Выызывается метод для получения объекта со значениями полей, введенными пользователем
     * @param list - объект кастомного класса листа
     * @param creator - объект для создания конкретного объекта
     * @param reader - поток для работы через консоль
     * @param <T> - тип объекта
     * @throws IOException
     */
    @Override
    public <T extends Comparable<T> & SomeEntity> void load(CustomList<T> list, EntityCreator<T> creator, BufferedReader reader) throws IOException {
        ConsoleReaderImpl consoleReader = new ConsoleReaderImpl();
        for (int i = 1; i <= list.getCapacity(); i++) {
            Optional<T> obj = consoleReader.getObjectFromConsole(creator, reader, i);
            obj.ifPresent(list::add);
        }

        if (list.size() != 0)
            System.out.println("\nСписок создан");
    }
}
