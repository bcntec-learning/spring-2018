package course.spring.mvc.thymeleaf.simple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SimpleController {


    @RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @ModelAttribute("author")
    public String author() {
        return "Francisco Philip";
    }


}