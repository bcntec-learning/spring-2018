package course.spring.mvc.thymeleaf.expert;

import lombok.Setter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafView;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.Collections;
import java.util.Locale;


@EnableWebMvc
@Configuration
public class ExpertMvcConfigurer implements WebMvcConfigurer, ApplicationContextAware {

    @Setter
    private ApplicationContext applicationContext;


    @Bean
    public ViewResolver htmlViewResolvers() {


        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("expert/html/");
        resolver.setSuffix(".html");
        resolver.setCacheable(false);
        resolver.setTemplateMode(TemplateMode.HTML);


        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine(resolver));
        viewResolver.setOrder(1);
        viewResolver.setContentType("text/html");
        viewResolver.setViewNames(new String[]{"*.html"});

        viewResolver.addStaticVariable("author", "Francisco Philip");
        // or viewResolver.setStaticVariables();
        return viewResolver;

    }

    @Bean
    public ViewResolver jsViewResolvers() {


        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("expert/js/");
        resolver.setSuffix(".js");
        resolver.setCacheable(true);
        resolver.setTemplateMode(TemplateMode.JAVASCRIPT);

        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine(resolver));
        viewResolver.setOrder(2);
        viewResolver.setContentType("application/javascript");
        viewResolver.setViewNames(new String[]{"*.js"});
        return viewResolver;

    }

    @Bean
    public ViewResolver cssViewResolvers() {


        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("expert/css/");
        resolver.setSuffix(".css");
        resolver.setCacheable(true);
        resolver.setTemplateMode(TemplateMode.CSS);

        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine(resolver));
        viewResolver.setOrder(3);
        viewResolver.setContentType("text/css");
        viewResolver.setViewNames(new String[]{"*.css"});

        viewResolver.addStaticVariable("logoCliente", "http://word./");
        viewResolver.addStaticVariable("backgroundColor", "red");
        return viewResolver;

    }


    private SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {

        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.addDialect(new Java8TimeDialect());
        engine.setTemplateResolver(templateResolver);
        engine.setTemplateEngineMessageSource(messageSource());

        return engine;
    }


    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
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


    @Bean("admin-main")
    @Scope("prototype")
    public ThymeleafView customView() {
        ThymeleafView view = new ThymeleafView("main"); // templateName = 'main'
        view.setApplicationContext(applicationContext);
        view.setContentType("text/html");

        view.setStaticVariables(
                Collections.singletonMap("author", "Francisco Philip"));
        return view;
    }


}
