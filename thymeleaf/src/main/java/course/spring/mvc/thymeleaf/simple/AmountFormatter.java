package course.spring.mvc.thymeleaf.simple;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.Formatter;
import org.springframework.format.number.NumberStyleFormatter;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Locale;

@NoArgsConstructor
public class AmountFormatter implements Formatter<BigDecimal> {

    @Getter
    private Amount.Style style;
    @Getter
    private NumberStyleFormatter formatter;

    public AmountFormatter style(Amount.Style style) {
        this.style = style;
        formatter = new NumberStyleFormatter(
                style == Amount.Style.DECIMAL ? "€#,##0.00" : "#,##0.00"
        );
        return this;
    }

    @Override
    public String print(BigDecimal amount, Locale locale) {
        return formatter.print(amount, locale);
    }

    @Override
    public BigDecimal parse(String text, Locale locale) throws ParseException {
        BigDecimal value = (BigDecimal) formatter.parse(text, locale);
        return value;
    }
}
