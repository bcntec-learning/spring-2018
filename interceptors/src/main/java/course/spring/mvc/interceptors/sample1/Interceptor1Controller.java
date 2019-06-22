package course.spring.mvc.interceptors.sample1;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/")
public class Interceptor1Controller {


    @ResponseBody
    @RequestMapping(value = "/")
    public ResponseEntity<String> intercepter(@PathParam("param") String param) {

        return ResponseEntity.ok(param);

    }


}

