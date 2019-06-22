package course.spring.mvc.controllers.sample2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(scanBasePackageClasses = {Controllers2Main.class},
        exclude = {SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class Controllers2Main {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(Controllers2Main.class).run(args);
    }
}

