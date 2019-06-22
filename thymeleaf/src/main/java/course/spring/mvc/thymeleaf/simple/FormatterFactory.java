package course.spring.mvc.thymeleaf.simple;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class FormatterFactory implements AnnotationFormatterFactory<Amount> {

    @Override
    public Set<Class<?>> getFieldTypes() {
        return new HashSet<>(Arrays.asList(
                BigDecimal.class,
                Float.class,
                Double.class));
    }

    @Override
    public Printer<?> getPrinter(Amount annotation, Class<?> fieldType) {
        return getAmountFormatter(annotation, fieldType);
    }

    @Override
    public Parser<?> getParser(Amount annotation, Class<?> fieldType) {
        return getAmountFormatter(annotation, fieldType);
    }

    private AmountFormatter getAmountFormatter(Amount annotation,
                                                 Class<?> fieldType) {
        return new AmountFormatter().style(annotation.value());
    }
}
