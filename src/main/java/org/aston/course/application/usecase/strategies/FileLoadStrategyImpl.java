package org.aston.course.application.usecase.strategies;

import org.aston.course.domain.model.SomeEntity;
import org.aston.course.domain.model.application.LoadStrategy;
import org.aston.course.domain.model.business.EntityCreator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileLoadStrategyImpl implements LoadStrategy {

    @Override
    public <T extends SomeEntity> void load(List<? super T> list, EntityCreator<T> creator) {
        System.out.println("Введите полный путь к файлу и его НАЗВАНИЕ.txt");
        Scanner scanner = new Scanner(System.in);
        String file = scanner.nextLine();
        FileReader fr;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(fr);
        while (true) {
            try {
                if (!br.ready()) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String lineName[];
            try {
                lineName = br.readLine().split(" ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            T temp = creator.create(lineName[0], lineName[1], lineName[2]);
            list.add(temp);
        }
    }
}
