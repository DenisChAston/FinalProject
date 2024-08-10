package org.aston.course.domain.business;
import org.aston.course.domain.model.SomeEntity;


public interface GeneratorStrategy<T extends SomeEntity>{

   T generator(EntityCreator<T> creator);
}


