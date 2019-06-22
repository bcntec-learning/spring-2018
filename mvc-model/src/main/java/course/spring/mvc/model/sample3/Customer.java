package course.spring.mvc.model.sample3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @NotNull
    @Size(min = 5)
    private String name;

    @NotNull
    private Long id;

    @NotNull
    @Email
    private String email;


}