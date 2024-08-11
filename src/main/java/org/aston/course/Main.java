package org.aston.course;


import org.aston.course.application.datasource.User;
import org.aston.course.application.usecase.creators.BusCreatorImpl;
import org.aston.course.application.usecase.creators.StudentCreatorImpl;
import org.aston.course.application.usecase.creators.UserCreatorImpl;
import org.aston.course.application.usecase.strategies.ConsoleLoadStrategyImpl;
import org.aston.course.application.usecase.strategies.FileLoadStrategyImpl;
import org.aston.course.application.usecase.strategies.RandomLoadStrategyImpl;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.domain.model.EntityCreator;
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
    private static final Map<String, EntityCreator> CREATE_STRATEGY_MAP = new HashMap<>();
    private static boolean END_OF_PROGRAM = false;

    static {
        LOAD_STRATEGY_MAP.put("1", new FileLoadStrategyImpl());
        LOAD_STRATEGY_MAP.put("2", new ConsoleLoadStrategyImpl());
        LOAD_STRATEGY_MAP.put("3", new RandomLoadStrategyImpl());

        CREATE_STRATEGY_MAP.put("1", new BusCreatorImpl());
        CREATE_STRATEGY_MAP.put("2", new UserCreatorImpl());
        CREATE_STRATEGY_MAP.put("3", new StudentCreatorImpl());
    }

    public static void main( String[] args ) throws IOException {

        String userInput = "";
        LoadStrategy loadStrategy = null;
        EntityCreator entityCreator = null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!END_OF_PROGRAM) {
                System.out.println("Выбирете тип объекта из списка:\n1.Автобус\n2.Пользователь\n3.Студент\n4.Выход из программы");
                userInput = reader.readLine();

                if (userInput.equals("4")) {
                    END_OF_PROGRAM = true;
                    continue;
                } else if (userInput.equals("5")) {
                    System.out.println("Введите цифру в диапазоне!");
                    continue;
                }
                entityCreator = CREATE_STRATEGY_MAP.get(userInput);

/*                switch (userInput) {
                    case "1" -> entityCreator = CREATE_STRATEGY_MAP.get("1");
                    case "2" -> entityCreator = CREATE_STRATEGY_MAP.get("2");
                    case "3" -> entityCreator = CREATE_STRATEGY_MAP.get("3");
                    case "4" -> {
                        END_OF_PROGRAM = true;
                        continue;
                    }
                    default -> {
                        System.out.println("Введите цифру в диапазоне!");
                        continue;
                    }
                }*/

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

                Context<?> con = new Context<User>(entityCreator, loadStrategy, reader, capacity);


/*                if (typeOfEntity ==1) {
                    Context<User> busCont = new Context<>(typeOfEntity, loadStrategy, reader, capacity);
                    END_OF_PROGRAM = busCont.startApp();
                } else if (typeOfEntity == 2) {
                    Context<User> busCont = new Context<>(typeOfEntity, loadStrategy, reader, capacity);
                    END_OF_PROGRAM = busCont.startApp();
                } else {
                    Context<User> busCont = new Context<>(typeOfEntity, loadStrategy, reader, capacity);
                    END_OF_PROGRAM = busCont.startApp();
                }*/


                con.startApp();
            }
        } catch (IOException e) {
            System.out.println("exc");
        }
    }
}
