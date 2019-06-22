package course.spring.mvc.thymeleaf.expert;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExpertController {

    @GetMapping("/")
    public String home() {
        return "main.html";
    }

    @GetMapping("/my.css")
    public String css() {
        return "my.css";
    }

    @GetMapping("/my.js")
    public String js() {
        return "my.js";
    }

    @GetMapping("/i18n")
    public String i18n() {
        return "i18n.html";
    }

}