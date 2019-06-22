package course.spring.mvc.controllers.sample1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/controllers1")
public class OtherExamplesController {

    @ResponseBody
    @RequestMapping(value = "/alive", headers = "Accept=*", produces = "text/plain", method = RequestMethod.GET)
    public String alive() {
        return "alive";
    }

    @ResponseBody
    @RequestMapping(value = "/alive-request", headers = "Accept=*", produces = "text/plain")
    public String alive(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        response.addCookie(new Cookie("my-cookie", "heyyy"));
        return "alive";
    }

}