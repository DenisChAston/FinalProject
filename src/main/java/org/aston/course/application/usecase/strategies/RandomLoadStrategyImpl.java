package org.aston.course.application.usecase.strategies;
import org.aston.course.application.usecase.validators.ValidatorRandStrategy;
import org.aston.course.domain.model.SomeEntity;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.domain.business.EntityCreator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
public class RandomLoadStrategyImpl implements LoadStrategy {

    @Override
    public <T extends SomeEntity> void load(List<? super T> list, EntityCreator<T> creator) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите количество объектов");
            int count = Integer.parseInt(reader.readLine());
            while (count > 0) {
                T temp = (T) new ValidatorRandStrategy().generator(creator);
                list.add(temp);
                count--;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


