package org.aston.course.application.usecase.strategies;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.application.usecase.exceptions.EmailFormatException;
import org.aston.course.application.usecase.exceptions.NegativeNumberException;
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

    /**
     * Метод заполнения списка объектами из файла
     * @param list - объект кастомного класса листа
     * @param creator - объект для создания конкретного объекта
     * @param reader - поток для работы через консоль
     * @param <T> - тип объекта
     * @throws IOException
     */
    @Override
    public <T extends Comparable<T> & SomeEntity> void load(CustomList<T> list, EntityCreator<T> creator, BufferedReader reader) throws IOException {
        List<String> temp;

        while (true) {
            System.out.println("\nВведите полный путь к файлу и его НАЗВАНИЕ.txt." +
                               "\nДля выхода введите q");
            String userInput = reader.readLine();
            if (userInput.equals("q"))
                return;

            Path pathFile = Path.of(userInput);
            if (Files.isRegularFile(pathFile) && Files.exists(pathFile)) {
                temp = Files.readAllLines(pathFile);
                break;
            }
            System.out.println("Файл не найден!");
        }

        int count = Math.min(temp.size(), list.getCapacity());
        for (int i = 0; i < count; i++) {
            String[] params = temp.get(i).split(" ");

            if (params.length != 3){
                System.out.println("Некоторые данные не могут быть прочитаны! Проверьте корректность сохраненных данных!");
                continue;
            }

            try {
                T tempObj = creator.create(params[0], params[1], params[2]);
                list.add(tempObj);
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат числа!");
            } catch (NegativeNumberException | EmailFormatException e) {
                System.out.println(e.getMessage());
            }
        }

        if (list.size() != 0) {
            System.out.println("Список загружен из файла");
        }

    }
}
