package course.spring.mvc.kendo;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@EnableWebMvc
public class KendoConfigurer implements WebMvcConfigurer, ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Bean
    public ViewResolver htmlViewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setOrder(0);
        //viewResolver.setContentType("text/html");
        viewResolver.setViewNames(new String[]{"*.html"});
        return viewResolver;
    }


    @Bean
    public SpringTemplateEngine templateEngine() {

        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setEnableSpringELCompiler(true);
        engine.addTemplateResolver(htmlTemplateResolver());
        engine.addDialect(new LayoutDialect());

        return engine;
    }


    private ITemplateResolver htmlTemplateResolver() {

        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix("classpath:/kendo-ui/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);


        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/img/**",
                "/js/**",
                "/styles/**")
                .addResourceLocations(
                        "classpath:/kendo-ui/js/",
                        "classpath:/kendo-ui/img/",
                        "classpath:/kendo-ui/styles/");
    }



}