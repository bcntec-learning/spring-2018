package course.spring.mvc.js;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackageClasses = {JsApplication.class},
        exclude = {SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class JsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsApplication.class, args);
    }


}