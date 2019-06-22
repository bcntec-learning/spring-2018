package course.spring.mvc.thymeleaf.template;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@Controller
public class TemplateController {

    @GetMapping({"/", "/home"})
    public String main() {
        return "home";
    }

    @GetMapping("/home2")
    public String main2() {
        return "home2";
    }


    @GetMapping("/f1")
    public String fragment1() {
        return "fragments :: #fragment1";
    }

    @GetMapping("/f2")
    public String fragment2() {
        return "fragments :: fragment2";
    }

    @GetMapping("/f3")
    public String f3() {
        return "fragments :: fragment3 ('param')";
    }


    @GetMapping("/search")
    public String search() {
        return "search";
    }


    @ModelAttribute("menuItems")
    List<String> items() {
        return Arrays.asList("home", "home2", "f1", "f2", "f3");
    }


}
