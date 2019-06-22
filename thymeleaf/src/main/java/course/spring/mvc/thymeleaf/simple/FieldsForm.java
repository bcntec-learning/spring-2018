package course.spring.mvc.thymeleaf.simple;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FieldsForm {

    private Boolean checkBox = true;
    private  Type[] allTypes = Type.values();
    private Type radio1= Type.B;
    private Type radio2= Type.E;
    private List<User> users;

    enum Type {
        A,B,C,D,E
    }

}
