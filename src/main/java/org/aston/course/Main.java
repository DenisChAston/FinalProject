package org.aston.course;


import org.aston.course.application.datasource.Bus;
import org.aston.course.application.datasource.Student;
import org.aston.course.application.datasource.User;
import org.aston.course.application.usecase.creators.BusCreatorImpl;
import org.aston.course.application.usecase.creators.StudentCreatorImpl;
import org.aston.course.application.usecase.creators.UserCreatorImpl;
import org.aston.course.application.usecase.strategies.ConsoleLoadStrategyImpl;
import org.aston.course.application.usecase.strategies.FileLoadStrategyImpl;
import org.aston.course.application.usecase.strategies.RandomLoadStrategyImpl;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.domain.model.EntityCreator;
import org.aston.course.domain.model.SomeEntity;
import org.aston.course.presentation.context.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * New project
 */

public class Main {

    private static final Map<String, LoadStrategy> LOAD_STRATEGY_MAP = new HashMap<>();;
    private static boolean END_OF_PROGRAM = false;

    static {
        LOAD_STRATEGY_MAP.put("1", new FileLoadStrategyImpl());
        LOAD_STRATEGY_MAP.put("2", new ConsoleLoadStrategyImpl());
        LOAD_STRATEGY_MAP.put("3", new RandomLoadStrategyImpl());
    }

    public static void main( String[] args ) throws IOException {

        String userInput = "";
        LoadStrategy loadStrategy = null;
        Context<? extends SomeEntity> con = null;
        String typeOfEntity = "";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!END_OF_PROGRAM) {
                System.out.println("Выбирете тип объекта из списка:\n1.Автобус\n2.Пользователь\n3.Студент\n4.Выход из программы");
                userInput = reader.readLine();

                switch (userInput) {
                    case "1", "2", "3" -> typeOfEntity = userInput;
                    case "4" -> END_OF_PROGRAM = true;
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
                    case "4" -> END_OF_PROGRAM = true;
                    default -> {
                        System.out.println("Введите цифру в диапазоне!");
                        continue;
                    }
                }

                System.out.println("\nУкажите количество объектов:");
                int capacity = Integer.parseInt(reader.readLine());

                switch (typeOfEntity) {
                    case "1" -> con = new Context<>(new BusCreatorImpl(), loadStrategy, reader, capacity);
                    case "2" -> con = new Context<>(new UserCreatorImpl(), loadStrategy, reader, capacity);
                    case "3" -> con = new Context<>(new StudentCreatorImpl(), loadStrategy, reader, capacity);
                }
                con.startApp();
            }
        } catch (IOException e) {
            System.out.println("exc");
        }
    }
}
