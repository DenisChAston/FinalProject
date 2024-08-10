package org.aston.course.presentation.context;

import org.aston.course.domain.business.sort.SelectionSort;
import org.aston.course.domain.model.SomeEntity;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.domain.business.EntityCreator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Context {

    private final LoadStrategy loadStrategy;
    private final EntityCreator<? extends SomeEntity> createStrategy;
    private final BufferedReader reader;
    private boolean endOfProgram = false;
    private boolean endOfLocalProgram = false;
    private final int listCapacity;
    private boolean listIsAlreadySort = false;

    private List<SomeEntity> list;


    public Context(LoadStrategy loadStrategy, EntityCreator<? extends SomeEntity> createStrategy, BufferedReader reader, int listCapacity) {
        this.loadStrategy = loadStrategy;
        this.createStrategy = createStrategy;
        this.reader = reader;
        this.listCapacity = listCapacity;
    }

    public boolean startApp() throws IOException {
        String userInput = "";
        List<SomeEntity> list = new ArrayList<>();
        //loadStrategy.load(list, createStrategy, listCapacity);

        while (!endOfLocalProgram) {

            System.out.println("Выберете действие:\n1.Сортировка\n2.Поиск объекта\n3.Печать списка\n4.Назад\n5.Выход");
            userInput = reader.readLine();
            switch (userInput) {
                case "1" -> {

                    //SelectionSort.sort(list);
                    //не запускается метод сортировки. На вход принимает List<T>, а мы передаем List<SomeEntity>
                    listIsAlreadySort = true;
                }
                case "2" -> {
                    if (!listIsAlreadySort) {
                        //SelectionSort.sort(list);
                    }
                    //сделать вызов метода поиска;
                }
                case "3" -> {
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
