package course.spring.mvc.thymeleaf.forms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class FormsController {


    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/first")
    public String first(ModelMap model) {
        MyForm1 n = new MyForm1();
        n.setFirst("1");
        model.addAttribute("myForm", n);
        return "form1";
    }


    @PostMapping("/first")
    public String first(@Valid @ModelAttribute("myForm") MyForm1 myForm, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "form1";
        }


        model.addAttribute("myForm", myForm);
        return "view1";

    }
}
