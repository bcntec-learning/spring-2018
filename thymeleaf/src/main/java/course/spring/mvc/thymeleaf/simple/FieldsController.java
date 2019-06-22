package course.spring.mvc.thymeleaf.simple;

import course.spring.mvc.thymeleaf.forms.MyForm1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class FieldsController {


    @GetMapping("/fields")
    public String iterations(ModelMap modelMap) {


        return "fields";
    }


    @PostMapping("/fields")
    public String first(@Valid @ModelAttribute("fieldsForm") FieldsForm myForm, BindingResult result, ModelMap model) {

        System.out.println("Radio1:"+myForm.getRadio1());
        for (User user : myForm.getUsers()) {
            System.out.println(user);
        }

        return "fields";
    }

    @ModelAttribute("fieldsForm")
    private FieldsForm fields() {

        List<User> users = Arrays.asList(
                new User(1L, "User 1", "user1@domain"),
                new User(2L, "User 2", "user2@domain"),
                new User(3L, "User 3", "user3@domain")

        );

        return FieldsForm.builder()
                .checkBox(true)
                .radio1(FieldsForm.Type.A)
                .radio2(FieldsForm.Type.E)
                .allTypes(FieldsForm.Type.values())
                .users(users)
                .build();
    }

}