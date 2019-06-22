package course.spring.mvc.configurer.sample1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/")
public class Configurer1Controller {


    @ResponseBody
    @RequestMapping(value = "/")
    public ResponseEntity<String> intercepter(@Tracker String track, @RequestParam("param") String param) {
        log.info("track:" + track);
        return ResponseEntity.ok(param);

    }


}

