package org.aston.course.domain.application;
import org.aston.course.domain.model.SomeEntity;
import org.aston.course.domain.business.EntityCreator;

import java.util.List;

public interface LoadStrategy {

   <T extends SomeEntity> void load(List<? super T> list, EntityCreator<T> creator);
}
