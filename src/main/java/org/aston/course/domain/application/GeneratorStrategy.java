package org.aston.course.domain.application;
import org.aston.course.domain.business.EntityCreator;
import org.aston.course.domain.model.SomeEntity;


public interface GeneratorStrategy<T extends SomeEntity>{

   T generator(EntityCreator<T> creator);
}


