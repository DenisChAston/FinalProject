package org.aston.course.application.usecase.strategies;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.domain.business.EntityCreator;
import org.aston.course.domain.model.SomeEntity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Стратегия заполнения списка объектами из файла
 */

public class FileLoadStrategyImpl implements LoadStrategy {

    //добавить валидацию

    /**
     * Метод заполнения списка объектами из файла
     * @param list - объект кастомного класса листа
     * @param creator - объект для создания конкретного объекта
     * @param <T> - тип объекта
     * @throws IOException
     */
    @Override
    public <T extends Comparable<T> & SomeEntity> void load(CustomList<T> list, EntityCreator<T> creator) throws IOException {
        System.out.println("Введите полный путь к файлу и его НАЗВАНИЕ.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();

        List<String> temp = Files.readAllLines(Path.of(file));

        int count = Math.min(temp.size(), list.getCapacity());
        for (int i = 0; i < count; i++) {
            String[] params = temp.get(i).split(" ");
            T tempObj = creator.create(params[0], params[1], params[2]);
            list.add(tempObj);
        }
    }
}
