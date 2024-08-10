package org.aston.course.application.usecase.strategies;
import org.aston.course.domain.model.SomeEntity;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.domain.business.EntityCreator;

import java.io.*;
import java.util.List;

public class FileLoadStrategyImpl implements LoadStrategy {

    @Override
    public <T extends SomeEntity> void load(List<? super T> list, EntityCreator<T> creator) {
        try {
            System.out.println("Введите полный путь к файлу и его НАЗВАНИЕ.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file = reader.readLine();
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            System.out.println("Введите количество загружаемых объектов:");
            int count = Integer.parseInt(reader.readLine());
            while (count > 0) {
                if (!br.ready()) break;
                String lineName[] = br.readLine().split(" ");
                T temp = creator.create(lineName[0], lineName[1], lineName[2]);
                list.add(temp);
                count--;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
