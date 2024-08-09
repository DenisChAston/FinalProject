package org.aston.course.presentation.context;

import org.aston.course.application.usecase.creators.BusCreatorImpl;
import org.aston.course.application.usecase.creators.PersonCreatorImpl;
import org.aston.course.application.usecase.creators.StudentCreatorImpl;
import org.aston.course.application.usecase.strategies.ConsoleLoadStrategyImpl;
import org.aston.course.application.usecase.strategies.FileLoadStrategyImpl;
import org.aston.course.application.usecase.strategies.RandomLoadStrategyImpl;
import org.aston.course.domain.model.SomeEntity;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.domain.business.EntityCreator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Context {

    private final Map<String, LoadStrategy> loadStrategyMap;

    private final Map<String, EntityCreator<? extends SomeEntity>> createStrategyMap;

    private List<SomeEntity> list;

    public Context() {
        loadStrategyMap = new HashMap<>();
        loadStrategyMap.put("1", new ConsoleLoadStrategyImpl());
        loadStrategyMap.put("2", new FileLoadStrategyImpl());
        loadStrategyMap.put("3", new RandomLoadStrategyImpl());

        createStrategyMap = new HashMap<>();
        createStrategyMap.put("1", new BusCreatorImpl());
        createStrategyMap.put("2", new StudentCreatorImpl());
        createStrategyMap.put("3", new PersonCreatorImpl());
    }

    public void startApp() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";

        while(!s.equals("Q")) {
            System.out.println("Введите класс");
            s = reader.readLine();
            list = new ArrayList<>();
            System.out.println("Введите откуда");
            String t = reader.readLine();
            loadStrategyMap.get(t).load(list, createStrategyMap.get(s), 2);
            System.out.println(list);

        }

    }

}
