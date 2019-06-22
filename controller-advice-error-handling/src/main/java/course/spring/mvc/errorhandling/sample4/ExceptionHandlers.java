package course.spring.mvc.errorhandling.sample4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Slf4j
public class ExceptionHandlers extends BaseExceptionHandler {

    public ExceptionHandlers() {
        super(log);
        registerMapping(MyEntityNotFoundException.class, "MY_ENTITY_NOT_FOUND", "My Entity not found", HttpStatus.NOT_FOUND);
    }
}