package course.spring.mvc.js;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JsController {

    @GetMapping({"/", "/home"})
    public String main() {
        return "home";
    }

    @GetMapping({"/http-request"})
    public String httpRequest() {
        return "ajax/http-request";
    }


    @GetMapping({"/synch-asynch"})
    public String synchAsync() {
        return "ajax/synch-asynch";
    }

    @GetMapping({"/query-selector"})
    public String querySelector() {
        return "window/query-selector";
    }

    @GetMapping({"/window"})
    public String eventsWindow() {
        return "events/window";
    }


}
