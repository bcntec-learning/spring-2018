package course.spring.mvc.thymeleaf.custom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "main";
    }

    @ModelAttribute("author")
    public String author() {
        return "Francisco Philip";
    }

}