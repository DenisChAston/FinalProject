package org.aston.course.application.usecase.validators;
import org.aston.course.application.usecase.creators.BusCreatorImpl;
import org.aston.course.application.usecase.creators.StudentCreatorImpl;
import org.aston.course.application.usecase.creators.UserCreatorImpl;
import org.aston.course.application.usecase.randoms.BusRandomImpl;
import org.aston.course.application.usecase.randoms.StudentRandomImpl;
import org.aston.course.application.usecase.randoms.UserRandomImpl;
import org.aston.course.domain.application.GeneratorStrategy;
import org.aston.course.domain.business.EntityCreator;
import org.aston.course.domain.model.SomeEntity;

public class ValidatorRandStrategy implements GeneratorStrategy {
    @Override
    public SomeEntity generator(EntityCreator creator) {
        if (creator instanceof UserCreatorImpl) {
            return new UserRandomImpl().generator(creator);
        } else if (creator instanceof BusCreatorImpl) {
            return new BusRandomImpl().generator(creator);
        } else if (creator instanceof StudentCreatorImpl) {
            return new StudentRandomImpl().generator(creator);
        }
        return null;
    }
}
