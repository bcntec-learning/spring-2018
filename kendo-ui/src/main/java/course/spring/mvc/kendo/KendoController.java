package course.spring.mvc.kendo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KendoController {

    @GetMapping({"/", "/home"})
    public String main() {
        return "home";
    }

    @GetMapping({"/autocomplete"})
    public String autocomplete() {
        return "autocomplete";
    }

    @GetMapping({"/datasource"})
    public String datasource() {
        return "datasource";
    }

    @GetMapping({"/ui"})
    public String ui() {
        return "ui";
    }

    @GetMapping({"/template"})
    public String template() {
        return "template";
    }

    @GetMapping({"/kendo"})
    public String kendo() {
        return "kendo";
    }
    @GetMapping({"/validator"})
    public String validator() {
        return "validator";
    }


    @GetMapping({"/numeric-textbox"})
    public String numericTextbox() {
        return "numeric-textbox";
    }


    @GetMapping({"/masked-textbox"})
    public String maskedTextbox() {
        return "masked-textbox";
    }


    @GetMapping({"/list-box"})
    public String listBox() {
        return "list-box";
    }

    @GetMapping({"/grid"})
    public String grid() {
        return "grid";
    }



    @GetMapping({"/grid-persons"})
    public String gridPersons() {
        return "grid-persons";
    }



}
