package org.aston.course.presentation.context;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.application.usecase.CustomUtils;
import org.aston.course.domain.business.EntityCreator;
import org.aston.course.domain.model.SomeEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;

public class BinarySearchContext {

    public <T extends SomeEntity & Comparable<T>> Optional<T> start(CustomList<T> list, EntityCreator<T> creator, BufferedReader reader) throws IOException {

        System.out.printf("Введите %s: ", creator.getFirstParamName());
        String firstParam = reader.readLine();
        System.out.printf("Введите %s: ", creator.getSecondParamName());
        String secondParam = reader.readLine();
        System.out.printf("Введите %s: ", creator.getThirdParamName());
        String thirdParam = reader.readLine();
        T tempEntity = creator.create(firstParam, secondParam, thirdParam);

        return CustomUtils.binarySearch(list, tempEntity);
    }
}
