package org.aston.course.application.usecase.strategies;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.domain.business.EntityCreator;
import org.aston.course.domain.model.SomeEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Сратегия заполнения списка объектами через консоль
 */

public class ConsoleLoadStrategyImpl implements LoadStrategy {


    /**
     * Метод заполнения списка объектами через консоль
     * @param list - объект кастомного класса листа
     * @param creator - объект для создания конкретного объекта
     * @param <T> - тип объекта
     * @throws IOException
     */
    @Override
    public <T extends Comparable<T> & SomeEntity> void load(CustomList<T> list, EntityCreator<T> creator) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= list.getCapacity(); i++) {
            System.out.printf("Введите %s %d: ", creator.getFirstParamName(), i);
            String firstParam = reader.readLine();
            System.out.printf("Введите %s %d: ", creator.getSecondParamName(), i);
            String secondParam = reader.readLine();
            System.out.printf("Введите %s %d: ", creator.getThirdParamName(), i);
            String thirdParam = reader.readLine();
            T tempEntity = creator.create(firstParam, secondParam, thirdParam);
            list.add(tempEntity);
        }
    }
}
