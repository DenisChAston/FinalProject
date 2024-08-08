package org.aston.course.application.datasource;

public enum Model {

    PAZ ("Паз"),
    LIAZ ("Лиаз"),
    MAZ ("Маз");

    private String name;

    Model(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
