package course.spring.mvc.kendo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackageClasses = {KendoApplication.class},
        exclude = {SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class KendoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KendoApplication.class, args);
    }


}