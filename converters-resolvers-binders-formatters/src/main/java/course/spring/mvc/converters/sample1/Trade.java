package course.spring.mvc.converters.sample1;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Trade {

    private Long id;
    private Type type;
    private BigDecimal value;

    public enum Type {
        BUY, SELL
    }
}