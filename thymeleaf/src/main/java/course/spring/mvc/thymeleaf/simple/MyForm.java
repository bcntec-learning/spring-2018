package course.spring.mvc.thymeleaf.simple;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor @AllArgsConstructor
public class MyForm {
    private Date date;
    private Float floatNumber;

}
