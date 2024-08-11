package org.aston.course;


import org.aston.course.application.datasource.Bus;
import org.aston.course.application.datasource.Student;
import org.aston.course.application.datasource.User;
import org.aston.course.application.usecase.comparators.BussEvenNumberComparatorImpl;
import org.aston.course.application.usecase.comparators.StudentEvenBussComparatorImpl;
import org.aston.course.application.usecase.creators.BusCreatorImpl;
import org.aston.course.application.usecase.creators.StudentCreatorImpl;
import org.aston.course.application.usecase.creators.UserCreatorImpl;
import org.aston.course.application.usecase.strategies.ConsoleLoadStrategyImpl;
import org.aston.course.application.usecase.strategies.FileLoadStrategyImpl;
import org.aston.course.application.usecase.strategies.RandomLoadStrategyImpl;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.domain.business.SomeComparator;
import org.aston.course.domain.model.SomeEntity;
import org.aston.course.presentation.context.MainContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * New project
 */

public class Main {

    private static final Map<String, LoadStrategy> LOAD_STRATEGY_MAP = new HashMap<>();
    private static final List<SomeComparator<Bus>> BUS_COMPARATORS = new ArrayList<>();
    private static final List<SomeComparator<Student>> STUDENT_COMPARATORS = new ArrayList<>();
    private static final List<SomeComparator<User>> USER_COMPARATORS = new ArrayList<>();

    private static boolean END_OF_PROGRAM = false;

    static {
        LOAD_STRATEGY_MAP.put("1", new FileLoadStrategyImpl());
        LOAD_STRATEGY_MAP.put("2", new ConsoleLoadStrategyImpl());
        LOAD_STRATEGY_MAP.put("3", new RandomLoadStrategyImpl());

        BUS_COMPARATORS.add(new BussEvenNumberComparatorImpl());
        STUDENT_COMPARATORS.add(new StudentEvenBussComparatorImpl());
    }

    public static void main( String[] args ) throws IOException {
        MainContext context = new MainContext();
        String userInput;
        String typeOfEntity = "";
        LoadStrategy loadStrategy;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (!END_OF_PROGRAM) {

                System.out.println("Выбирете тип объекта из списка:\n1.Автобус\n2.Пользователь\n3.Студент\n4.Выход из программы");
                userInput = reader.readLine();

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

                System.out.println("\nВыбирете стратегию заполнения списка:\n1.Из файла\n2.Вручную\n3.Случайно\n4.Выход");
                userInput = reader.readLine();
                switch (userInput) {
                    case "1" -> loadStrategy = LOAD_STRATEGY_MAP.get("1");
                    case "2" -> loadStrategy = LOAD_STRATEGY_MAP.get("2");
                    case "3" -> loadStrategy = LOAD_STRATEGY_MAP.get("3");
                    case "4" -> {
                        END_OF_PROGRAM = true;
                        continue;
                    }
                    default -> {
                        System.out.println("Введите цифру в диапазоне!");
                        continue;
                    }
                }

                System.out.println("\nУкажите количество объектов:");
                int capacity = Integer.parseInt(reader.readLine());

                switch (typeOfEntity) {
                    case "1" -> END_OF_PROGRAM = context.start(new BusCreatorImpl(), loadStrategy, reader, capacity, BUS_COMPARATORS);
                    case "2" -> END_OF_PROGRAM = context.start(new UserCreatorImpl(), loadStrategy, reader, capacity, USER_COMPARATORS);
                    case "3" -> END_OF_PROGRAM = context.start(new StudentCreatorImpl(), loadStrategy, reader, capacity, STUDENT_COMPARATORS);
                }
            }
        } catch (IOException e) {
            System.out.println("exc");
        }
    }
}
