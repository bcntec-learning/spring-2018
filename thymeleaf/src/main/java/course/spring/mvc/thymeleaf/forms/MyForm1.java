package course.spring.mvc.thymeleaf.forms;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class MyForm1 {
    @Size(min = 2, max = 10)
    private String first;
    @NotEmpty
    private String last;

    @Min(2)
    private Long value;
}
