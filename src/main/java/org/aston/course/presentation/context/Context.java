package org.aston.course.presentation.context;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.application.usecase.CustomUtils;
import org.aston.course.application.usecase.sort.SelectionSort;
import org.aston.course.domain.model.EntityCreator;
import org.aston.course.domain.model.SomeEntity;

import java.io.BufferedReader;
import java.io.IOException;

public class Context<T extends Comparable<T> & SomeEntity> {

    private final LoadStrategy loadStrategy;
    private final EntityCreator<T> entityCreator;
    private final BufferedReader reader;
    private boolean endOfProgram = false;
    private boolean endOfLocalProgram = false;
    private final int listCapacity;
    private boolean listIsAlreadySort = false;

    public Context(EntityCreator<T> entityCreator, LoadStrategy loadStrategy, BufferedReader reader, int listCapacity) {
        this.loadStrategy = loadStrategy;
        this.entityCreator = entityCreator;
        this.reader = reader;
        this.listCapacity = listCapacity;
    }

    public boolean startApp() throws IOException {
        String userInput = "";
        CustomList<T> list = new CustomList<>(listCapacity);
        loadStrategy.load(list, entityCreator);

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



