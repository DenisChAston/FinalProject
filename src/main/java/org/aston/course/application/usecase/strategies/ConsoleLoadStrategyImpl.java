package org.aston.course.application.usecase.strategies;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.domain.model.EntityCreator;

import java.util.Scanner;

public class ConsoleLoadStrategyImpl implements LoadStrategy {

    @Override
    public <T extends Comparable<T>> void load(CustomList<T> list, EntityCreator creator) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= list.getCapasity(); i++) {
            System.out.printf("Введите %s %d\n", creator.getFirstParamName(), i);
            String f = scanner.next();
            System.out.printf("Введите %s %d\n", creator.getSecondParamName(), i);
            String s = scanner.next();
            System.out.printf("Введите %s %d\n", creator.getThirdParamName(), i);
            String t = scanner.next();
            T temp = creator.create(f, s, t);
            list.add(temp);
        }
    }
}
