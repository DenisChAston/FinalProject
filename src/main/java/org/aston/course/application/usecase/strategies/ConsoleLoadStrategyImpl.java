package org.aston.course.application.usecase.strategies;
import org.aston.course.domain.model.SomeEntity;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.domain.business.EntityCreator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ConsoleLoadStrategyImpl implements LoadStrategy {
    @Override
    public <T extends SomeEntity> void load(List<? super T> list, EntityCreator<T> creator) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите количество объектов в базе данных:");
        try {
            for (int i = Integer.parseInt(reader.readLine()); i > 0; i--) {
                System.out.println("Введите первый параметр объекта");
                String f = reader.readLine();
                System.out.println("Введите второй параметр объекта");
                String s = reader.readLine();
                System.out.println("Введите третий параметр объекта");
                String t = reader.readLine();
                T temp = creator.create(f, s, t);
                list.add(temp);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
