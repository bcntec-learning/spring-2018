package course.spring.mvc.thymeleaf.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackageClasses = {SimpleApplication.class},
        exclude = {SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class SimpleApplication {

    public static void main(String[] args) {
        System.getProperties().setProperty("spring.thymeleaf.prefix","classpath:/simple/");
        SpringApplication.run(SimpleApplication.class, args);
    }


}