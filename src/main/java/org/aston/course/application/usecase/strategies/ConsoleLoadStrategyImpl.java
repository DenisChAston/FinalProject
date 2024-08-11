package org.aston.course.application.usecase.strategies;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.domain.business.EntityCreator;
import org.aston.course.domain.model.SomeEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleLoadStrategyImpl implements LoadStrategy {

    @Override
    public <T extends Comparable<T> & SomeEntity> void load(CustomList<T> list, EntityCreator<T> creator) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= list.getCapacity(); i++) {
            System.out.printf("Введите %s %d\n", creator.getFirstParamName(), i);
            String firstParam = reader.readLine();
            System.out.printf("Введите %s %d\n", creator.getSecondParamName(), i);
            String secondParam = reader.readLine();
            System.out.printf("Введите %s %d\n", creator.getThirdParamName(), i);
            String thirdParam = reader.readLine();
            T tempEntity = creator.create(firstParam, secondParam, thirdParam);
            list.add(tempEntity);
        }
    }
}
