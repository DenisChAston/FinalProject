package org.aston.course.application.usecase.strategies;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.domain.model.SomeEntity;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.domain.business.EntityCreator;

import java.util.List;
import java.util.Scanner;

public class ConsoleLoadStrategyImpl implements LoadStrategy {

    @Override
    public <T extends Comparable<T>> void load(CustomList<T> list, EntityCreator creator, int entityCount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество объектов в базе данных:");
        for (int i = scanner.nextInt(); i > 0; i--) {
            System.out.println("Введите первый параметр объекта");
            String f = scanner.next();
            System.out.println("Введите второй параметр объекта");
            String s = scanner.next();
            System.out.println("Введите третий параметр объекта");
            String t = scanner.next();
            T temp = creator.create(f, s, t);
            list.add(temp);
        }
    }
}
