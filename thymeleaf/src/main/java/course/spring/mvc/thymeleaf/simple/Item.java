package course.spring.mvc.thymeleaf.simple;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Amount(Amount.Style.DECIMAL)
    BigDecimal quantity;
    @Amount(Amount.Style.CURRENCY)
    BigDecimal cost;
}
