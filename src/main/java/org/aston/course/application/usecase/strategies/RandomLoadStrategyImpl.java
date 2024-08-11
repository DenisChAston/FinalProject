package org.aston.course.application.usecase.strategies;

import org.aston.course.application.usecase.creators.BusCreatorImpl;
import org.aston.course.application.usecase.creators.StudentCreatorImpl;
import org.aston.course.application.usecase.creators.UserCreatorImpl;
import org.aston.course.application.usecase.randoms.BusRandomImpl;
import org.aston.course.application.usecase.randoms.StudentRandomImpl;
import org.aston.course.application.usecase.randoms.UserRandomImpl;
import org.aston.course.domain.application.GeneratorStrategy;
import org.aston.course.domain.model.SomeEntity;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.domain.business.EntityCreator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class RandomLoadStrategyImpl implements LoadStrategy, GeneratorStrategy {

    @Override
    public <T extends SomeEntity> void load(List<? super T> list, EntityCreator<T> creator) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите количество объектов");
            int count = Integer.parseInt(reader.readLine());
            while (count > 0) {
                T temp = (T) generator(creator);
                list.add(temp);
                count--;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public SomeEntity generator(EntityCreator creator) {
        if (creator.getClass().equals(StudentCreatorImpl.class)) {
            StudentRandomImpl studentRandom = new StudentRandomImpl();
            return studentRandom.generator(creator);
        } else if (creator.getClass().equals(BusCreatorImpl.class)) {
            BusRandomImpl busRandom = new BusRandomImpl();
            return busRandom.generator(creator);
        } else if (creator.getClass().equals(UserCreatorImpl.class)) {
            UserRandomImpl userRandom = new UserRandomImpl();
            return userRandom.generator(creator);
        }
        return null;
    }
}


