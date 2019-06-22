package course.spring.mvc.jquery;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JQueryController {

    @GetMapping({"/", "/home"})
    public String main() {
        return "home";
    }

    @GetMapping({"/window"})
    public String eventsWindow() {
        return "events/window";
    }

    @GetMapping({"/query-selector"})
    public String querySelector() {
        return "window/query-selector";
    }



    @GetMapping({"/http-request"})
    public String httpRequest() {
        return "ajax/http-request";
    }


}
