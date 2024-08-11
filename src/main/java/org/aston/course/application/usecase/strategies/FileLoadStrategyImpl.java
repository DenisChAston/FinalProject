package org.aston.course.application.usecase.strategies;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.domain.model.EntityCreator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileLoadStrategyImpl implements LoadStrategy {

    @Override
    public <T extends Comparable<T>> void load(CustomList<T> list, EntityCreator creator) throws IOException {
        System.out.println("Введите полный путь к файлу и его НАЗВАНИЕ.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        List<String> temp = Files.readAllLines(Path.of(file));

        int count = Math.min(temp.size(), list.getCapacity());

        for (int i = 0; i < count; i++) {
            String[] params = temp.get(i).split(" ");
            T tempObj = creator.create(params[0], params[1], params[2]);
            list.add(tempObj);
        }



        /*Scanner scanner = new Scanner(System.in);
        String file = scanner.nextLine();
        FileReader fr;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(fr);
        for (int i = 0; i < list.size(); i++) {
            try {
                if (!br.ready()) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String[] lineName;
            try {
                lineName = br.readLine().split(" ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            T temp = creator.create(lineName[0], lineName[1], lineName[2]);
            list.add(temp);
        }*/
    }
}
