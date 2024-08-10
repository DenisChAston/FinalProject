package org.aston.course.presentation.context;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.application.usecase.creators.BusCreatorImpl;
import org.aston.course.application.usecase.creators.StudentCreatorImpl;
import org.aston.course.application.usecase.creators.UserCreatorImpl;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.application.usecase.CustomUtils;
import org.aston.course.application.usecase.sort.SelectionSort;
import org.aston.course.domain.model.EntityCreator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Context<T extends Comparable<T>> {

    private static final Map<Integer, EntityCreator> CREATE_STRATEGY_MAP = new HashMap<>();
    private final int typeOfEntity;

    private final LoadStrategy loadStrategy;
    private final BufferedReader reader;
    private boolean endOfProgram = false;
    private boolean endOfLocalProgram = false;
    private final int listCapacity;
    private boolean listIsAlreadySort = false;

    static {
        CREATE_STRATEGY_MAP.put(1, new BusCreatorImpl());
        CREATE_STRATEGY_MAP.put(2, new UserCreatorImpl());
        CREATE_STRATEGY_MAP.put(3, new StudentCreatorImpl());
    }

    public Context(int typeOfEntity, LoadStrategy loadStrategy, BufferedReader reader, int listCapacity) {
        this.typeOfEntity = typeOfEntity;
        this.loadStrategy = loadStrategy;
        this.reader = reader;
        this.listCapacity = listCapacity;
    }

    public boolean startApp() throws IOException {
        String userInput = "";
        CustomList<T> list = new CustomList<>(listCapacity);
        loadStrategy.load(list, CREATE_STRATEGY_MAP.get(typeOfEntity));

        while (!endOfLocalProgram) {
            System.out.println("Выберете действие:\n1.Сортировка\n2.Поиск объекта\n3.Печать списка\n4.Назад\n5.Выход");
            userInput = reader.readLine();
            switch (userInput) {
                case "1" -> {
                    CustomUtils.sort(list, new SelectionSort<>());
                    listIsAlreadySort = true;
                }
                case "2" -> {
                    if (!listIsAlreadySort) {
                        CustomUtils.sort(list, new SelectionSort<>());
                    }
                    //list.binarySearch();
                    //сделать вызов метода поиска;
                }
                case "3" -> {
                    CustomUtils.print(list);
                    //вызов метода печати списка
                }
                case "4" -> {
                    endOfProgram = false;
                    endOfLocalProgram = true;
                }
                case "5" -> {
                    endOfProgram = true;
                    endOfLocalProgram = true;
                }
                default -> System.out.println("Введите цифру в диапазоне!");
            }
        }
        return endOfProgram;
    }
}



