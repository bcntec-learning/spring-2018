package course.spring.mvc.controllers.sample2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AllMethodsController {

    //GET,  POST, PUT, PATCH, DELETE, , TRACE
    @ResponseBody
    @GetMapping("/echo")
    public String getEcho(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        return name;
    }

    @ResponseBody
    @PutMapping("/echo")
    public String putEcho(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        return name;
    }

    @ResponseBody
    @PatchMapping("/echo")
    public String patchEcho(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        return name;
    }

    @ResponseBody
    @DeleteMapping("/echo")
    public String deleteEcho(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        return name;
    }
}