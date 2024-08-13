package org.aston.course;


import org.aston.course.application.datasource.Bus;
import org.aston.course.application.datasource.Student;
import org.aston.course.application.datasource.User;
import org.aston.course.application.usecase.comparators.BusEvenNumberComparatorImpl;
import org.aston.course.application.usecase.comparators.BusNotEvenNumberComparatorImpl;
import org.aston.course.application.usecase.comparators.StudentEvenGroupComparatorImpl;
import org.aston.course.application.usecase.comparators.StudentNotEvenGroupComparatorImpl;
import org.aston.course.application.usecase.creators.BusCreatorImpl;
import org.aston.course.application.usecase.creators.StudentCreatorImpl;
import org.aston.course.application.usecase.creators.UserCreatorImpl;
import org.aston.course.application.usecase.strategies.ConsoleLoadStrategyImpl;
import org.aston.course.application.usecase.strategies.FileLoadStrategyImpl;
import org.aston.course.application.usecase.strategies.RandomLoadStrategyImpl;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.domain.business.SomeComparator;
import org.aston.course.presentation.context.MainContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project
 */

public class Main {

    /**
     * Мапа и списки для конфигурации приложения
     */

    private static final Map<String, LoadStrategy> LOAD_STRATEGY_MAP = new HashMap<>();
    private static final List<SomeComparator<Bus>> BUS_COMPARATORS = new ArrayList<>();
    private static final List<SomeComparator<Student>> STUDENT_COMPARATORS = new ArrayList<>();
    private static final List<SomeComparator<User>> USER_COMPARATORS = new ArrayList<>();

    private static boolean END_OF_PROGRAM = false;

    /**
     * Заполнение списков и мапы для конфигурации приложения
     */

    static {
        LOAD_STRATEGY_MAP.put("1", new FileLoadStrategyImpl());
        LOAD_STRATEGY_MAP.put("2", new ConsoleLoadStrategyImpl());
        LOAD_STRATEGY_MAP.put("3", new RandomLoadStrategyImpl());

        BUS_COMPARATORS.add(new BusEvenNumberComparatorImpl());
        BUS_COMPARATORS.add(new BusNotEvenNumberComparatorImpl());
        STUDENT_COMPARATORS.add(new StudentEvenGroupComparatorImpl());
        STUDENT_COMPARATORS.add(new StudentNotEvenGroupComparatorImpl());
    }

    public static void main( String[] args ) throws IOException {
        MainContext context = new MainContext();
        String userInput;
        String typeOfEntity = "";
        LoadStrategy loadStrategy;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (!END_OF_PROGRAM) {

                System.out.print("\n1.Автобус\n" +
                                 "2.Пользователь\n" +
                                 "3.Студент\n" +
                                 "4.Выход из программы\n" +
                                 "Выбирите тип: ");
                userInput = reader.readLine();

                //на основании введенной цифры определяется тип объекта, скотором хочет работать пользователь
                switch (userInput) {
                    case "1", "2", "3" -> typeOfEntity = userInput;
                    case "4" -> {
                        END_OF_PROGRAM = true;
                        continue;
                    }
                    default -> {
                        System.out.println("Введите цифру в диапазоне!");
                        continue;
                    }
                }

                System.out.print("\n1.Из файла\n" +
                                 "2.Вручную\n" +
                                 "3.Случайно\n" +
                                 "4.Назад\n" +
                                 "5.Выход\n" +
                                 "Выбирете стратегию заполнения списка: ");
                userInput = reader.readLine();

                //на основании введенной цифры определяется стратегия заполнения списка
                switch (userInput) {
                    case "1" -> loadStrategy = LOAD_STRATEGY_MAP.get("1");
                    case "2" -> loadStrategy = LOAD_STRATEGY_MAP.get("2");
                    case "3" -> loadStrategy = LOAD_STRATEGY_MAP.get("3");
                    case "4" -> {
                        END_OF_PROGRAM = false;
                        continue;
                    }
                    case "5" -> {
                        END_OF_PROGRAM = true;
                        continue;
                    }
                    default -> {
                        System.out.println("Введите цифру в диапазоне!");
                        continue;
                    }
                }

                System.out.print("\nУкажите количество объектов: ");
                int capacity = 0;
                try {
                    capacity = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e) {
                    System.out.println("Укажите количество объектов числом!");
                    continue;
                }

                if (capacity <= 0) {
                    System.out.println("Количество объектов не может быть меньше 1");
                    continue;
                }

                //в зависимости от введенного типа объекта, формируются параметры контекста приложения. приложение запускается на выполнение
                switch (typeOfEntity) {
                    case "1" -> END_OF_PROGRAM = context.start(new BusCreatorImpl(), loadStrategy, reader, capacity, BUS_COMPARATORS);
                    case "2" -> END_OF_PROGRAM = context.start(new UserCreatorImpl(), loadStrategy, reader, capacity, USER_COMPARATORS);//исключение, тк нет компараторов
                    case "3" -> END_OF_PROGRAM = context.start(new StudentCreatorImpl(), loadStrategy, reader, capacity, STUDENT_COMPARATORS);
                }
            }
        } catch (IOException e) {
            System.out.println("exc");
        }
    }
}
