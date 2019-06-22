package course.spring.mvc.configurer.sample1;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class Configurer1Configurer implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new TrackerArgumentResolver());
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        //registry.addConverter(new StringToTradeConverter());

        //registry.addConverterFactory(new StringToMyEnumsConverterFactory());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("file:/resources/", "classpath:/resources/")
                .setCachePeriod(3600);

    }
}
