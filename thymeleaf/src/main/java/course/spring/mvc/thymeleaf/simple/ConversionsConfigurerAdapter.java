package course.spring.mvc.thymeleaf.simple;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.number.PercentStyleFormatter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.text.ParseException;
import java.util.Locale;


@Configuration
public class ConversionsConfigurerAdapter implements WebMvcConfigurer {


    @Override
    public void addFormatters(final FormatterRegistry registry) {
        registry.addFormatter(userFormatter());
        registry.addFormatter(dateFormatter());
        //registry.addFormatter(new PercentStyleFormatter());
        registry.addFormatterForFieldType(Float.class, new PercentStyleFormatter());
        registry.addFormatterForFieldAnnotation(new FormatterFactory());
    }

    @Bean
    public Formatter<User> userFormatter() {

        return new Formatter<User>(){

            @Override
            public String print(User object, Locale locale) {
                return object.getName();
            }

            @Override
            public User parse(String text, Locale locale) throws ParseException {
                return new User(1L, null, text);
            }
        };

    }

    @Bean
    public PercentStyleFormatter percentStyleFormatter() {
        return new PercentStyleFormatter();
    }
    @Bean
    public DateFormatter dateFormatter() {
        return new DateFormatter("dd-MM-yyyy HH:mm");
    }




    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("forms");
        return messageSource;
    }


    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("en"));
        return localeResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

}
