package course.spring.mvc.controllers.sample1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static javax.servlet.http.HttpServletResponse.SC_MOVED_TEMPORARILY;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@Controller
@RequestMapping("/controllers1")
public class MyFirstController {


    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping(value = {"/first", "my-first"}) // /controllers1/first
    public void first() {
        System.out.println("aloooo");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @RequestMapping(value = "/second") // /controllers1/second
    public void second() {
        System.out.println("aloooo");
    }

    @ResponseStatus(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED)
    @ResponseBody
    @RequestMapping(value = "/third") // /controllers1/second
    public String third() {
        return "te has excedido";
    }

    @ResponseStatus(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED)
    @ResponseBody
    @RequestMapping(value = "/fourth",
            produces = APPLICATION_JSON_UTF8_VALUE) // /controllers1/fourth
    public String fourth() {
        return "{\"error\":{ \"desc\":\"te has excedido\"}}";
    }


    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping(value = "/fourth",
            params = {"param"},
            produces = APPLICATION_JSON_UTF8_VALUE) // /controllers1/fourth
    public String fourth(HttpServletRequest request) {
        return "{\"ok\" :{ \"desc\":\"" + request.getParameter("param") + "\"}}";
    }


    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping(value = "/fifth",
            params = {"p"},
            produces = APPLICATION_JSON_UTF8_VALUE) // /controllers1/fourth
    public String fifth(@RequestParam(name = "p", defaultValue = "no se quien eres") String param) {
        return "{\"ok\"  :{ \"desc\":\"" + param + "\"}}";
    }


    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping(value = "/fifth/{i}",
            produces = APPLICATION_JSON_UTF8_VALUE) // /controllers1/fifth
    public String fifth(@PathVariable(name = "i") Long param) {
        return "{\"ok\"  :{ \"fifth\":\"" + param + "\"}}";
    }

    @ResponseBody
    @RequestMapping(value = "/users/{i}",
            produces = APPLICATION_JSON_UTF8_VALUE) // /controllers1/fifth
    public String users(@PathVariable(name = "i") Long pk, HttpServletResponse response) {

        if ((pk % 2) > 0) {
            response.setStatus(HttpStatus.OK.value());
            return "{\"user\":{ \"pk\":\"" + pk + "\"}}";
        }

        response.setStatus(HttpStatus.NOT_FOUND.value());
        return "{\"error\":{ \"desc\":\"not found\"}}";

    }


    @ResponseBody
    @RequestMapping(value = "/users2/{i}",
            method = RequestMethod.GET,
            consumes = APPLICATION_JSON_UTF8_VALUE,
            produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> users2(@PathVariable(name = "i") Long pk, HttpServletRequest r) {
        HttpStatus s = HttpStatus.NOT_FOUND;
        String body = "{\"error\":{ \"desc\":\"not found\"}}";
        if ((pk % 2) > 0) {
            s = HttpStatus.OK;
            body = "{\"user-get\" :{ \"pk\":\"" + pk + "\"}, \"method\":\"GET}";
        }

        return ResponseEntity.status(s).body(body);

    }

    @ResponseBody
    @RequestMapping(value = "/users2/{i}",
            method = RequestMethod.GET,
            produces = "text/html")
    public ResponseEntity<String> users2_html(@PathVariable(name = "i") Long pk, HttpServletRequest r) {


        String body = "<html><body>" + pk + "</body></html>";

        return ResponseEntity.status(HttpStatus.OK).body(body);

    }


    @ResponseBody
    @RequestMapping(value = "/users2/{i}",
            method = {RequestMethod.POST, RequestMethod.PATCH},
            produces = APPLICATION_JSON_UTF8_VALUE) // /controllers1/users2
    public ResponseEntity<String> users2_POST(@PathVariable(name = "i") Long pk) {
        HttpStatus s = HttpStatus.NOT_FOUND;
        String body = "{\"error\":{ \"desc\":\"not found\"}}";
        if ((pk % 2) > 0) {
            s = HttpStatus.OK;
            body = "{\"user\":{ \"pk\":\"" + pk + "\"}, \"method\":\"POST/PATCH\"}";
        }

        return ResponseEntity.status(s).body(body);

    }

    @ResponseBody
    @RequestMapping(value = "/users3/{i}",
            method = {RequestMethod.PUT},
            consumes = APPLICATION_JSON_UTF8_VALUE,
            produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> users3_PUT(@PathVariable(name = "i") Long pk) {
        HttpStatus s = HttpStatus.NOT_FOUND;
        String body = "{\"error\":{ \"desc\":\"not found\"}}";
        if ((pk % 2) > 0) {
            s = HttpStatus.OK;
            body = "{\"user\":{ \"pk\":\"" + pk + "\"}, \"method\":\"PUT\", \"consume\": \"JSON\"}";
        }

        return ResponseEntity.status(s).body(body);

    }

    @ResponseBody
    @RequestMapping(value = "/users3/{i}",
            method = {RequestMethod.PUT},
            consumes = APPLICATION_XML_VALUE,
            produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> users3_PUT_XML(@PathVariable(name = "i") Long pk) {
        HttpStatus s = HttpStatus.NOT_FOUND;
        String body = "{\"error\":{ \"desc\":\"not found\"}}";
        if ((pk % 2) > 0) {
            s = HttpStatus.OK;
            body = "{\"user\":{ \"pk\":\"" + pk + "\"}, \"method\":\"PUT\", \"consume\": \"XML\"}";
        }

        return ResponseEntity.status(s).body(body);

    }

    @ResponseBody
    @RequestMapping(value = "/users3/{i}",
            headers = "Hola=Mundo")
    public ResponseEntity<String> users3_HolaMundo(@PathVariable(name = "i") Long pk) {
        HttpStatus s = HttpStatus.NOT_FOUND;
        String body = "{\"error\":{ \"desc\":\"not found\"}}";
        if ((pk % 2) > 0) {
            s = HttpStatus.OK;
            body = "{\"user\":{ \"pk\":\"" + pk + "\"}, \"method\":\"*\", \"consume\": \"Hola=Mundo\"}";
        }

        return ResponseEntity.status(s).body(body);

    }


    @ResponseBody
    @RequestMapping(value = "/users3/{i}",
            headers = "Hola=Todos")
    public ResponseEntity<String> users3_HolaTodos(@PathVariable(name = "i") Long pk) {
        HttpStatus s = HttpStatus.NOT_FOUND;
        String body = "{\"error\":{ \"desc\":\"not found\"}}";
        if ((pk % 2) > 0) {
            s = HttpStatus.OK;
            body = "{\"user\":{ \"pk\":\"" + pk + "\"}, \"method\":\"*\", \"consume\": \"Hola=Todos\"}";
        }

        return ResponseEntity.status(s).body(body);

    }

    @ResponseBody
    @RequestMapping(value = "/users3/{i}", produces = "text/html")
    public ResponseEntity<String> users3_HTML(@PathVariable(name = "i") Long pk) {
        String body = "<html><body>" + pk + "</body></html>";

        return ResponseEntity.ok(body);

    }


    /*
     * Create a cookie
     */


    @ResponseBody
    @RequestMapping(value = "/cookie", params = {"val"})
    public ResponseEntity<String> cookie(@RequestParam("val") Long val,
                                         HttpServletResponse response) {
        Cookie cookie = new Cookie("cookie1", val + "");
        cookie.setMaxAge(600);
        response.addCookie(cookie);

        return ResponseEntity.ok("va cookie!!!!!");

    }


    /*
     * Accept if cookie exist
     */

    @ResponseBody
    @RequestMapping(value = "/cookie")
    public ResponseEntity<String> cookie(
            @CookieValue(name = "cookie1") Long val, @CookieValue(name = "cookie1") Cookie cookie) {


        return ResponseEntity.ok("viene cookie 1:" + val);

    }



}
