package org.aston.course.domain.model;

public interface SomeEntity<T> extends Comparable<T> {

    // лучше будет сделать отдельный интерфейс, чтобы убрать из юзера этот метод
    boolean isEvenNumber();

}
