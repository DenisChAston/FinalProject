package org.aston.course.application.usecase.strategies;

import org.aston.course.domain.model.SomeEntity;
import org.aston.course.domain.model.application.LoadStrategy;
import org.aston.course.domain.model.business.EntityCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleLoadStrategyImpl implements LoadStrategy {

    @Override
    public <T extends SomeEntity> void load(List<? super T> list, EntityCreator<T> creator) {
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
