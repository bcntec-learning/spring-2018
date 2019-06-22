package course.spring.mvc.thymeleaf.forms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackageClasses = {FormsApplication.class},
        exclude = {SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class FormsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormsApplication.class, args);
    }


}