package org.aston.course.application.usecase;

import org.aston.course.application.usecase.exceptions.EmailFormatException;
import org.aston.course.application.usecase.exceptions.NegativeNumberException;
import org.aston.course.domain.business.EntityCreator;
import org.aston.course.domain.model.SomeEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;

/**
 * Класс для работы с пользователем через консоль
 * для создания объекта со значениями полей, введенными пользователем
 */
public class ConsoleReaderImpl {

    /**
     * Метод считывает значения полей, введенные пользователем.
     * Создает объект нужного типа. Упаковывает его в Optional и выдает в вызывающий метод
     * Если не удалось создать объект с введенными параметрами, то в Optional записывается пустое значение
     * @param creator - объект для создания конкретного объектам
     * @param reader - поток для работы через консоль
     * @param i - порядковый номер создаваемого объекта
     * @return - Optional, в котором упакован либо полученный объект, либо пустое значение
     * @param <T> - тип объекта
     * @throws IOException
     */

    public <T extends SomeEntity> Optional<T> getObjectFromConsole(EntityCreator<T> creator, BufferedReader reader, int i) throws IOException {
        Optional<T> obj = Optional.empty();
        System.out.printf("\nВведите %s %d: ", creator.getFirstParamName(), i);
        String firstParam = reader.readLine();
        System.out.printf("Введите %s %d: ", creator.getSecondParamName(), i);
        String secondParam = reader.readLine();
        System.out.printf("Введите %s %d: ", creator.getThirdParamName(), i);
        String thirdParam = reader.readLine();

        try {
            obj = Optional.of(creator.create(firstParam, secondParam, thirdParam));
        } catch (NumberFormatException e) {
            System.out.println("\nНеверный формат числа!");
        } catch (NegativeNumberException | EmailFormatException e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }
}
