package course.spring.mvc.thymeleaf.simple;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Controller
public class UtilityController {



    @GetMapping("/utility-objects")
    public String iterations(ModelMap modelMap) {


        modelMap.addAttribute("date1", new Date());
        modelMap.addAttribute("number1", new BigDecimal(100.56f));
        modelMap.addAttribute("calendar1", Calendar.getInstance());
        modelMap.addAttribute("string1", "hello world!!");
        String nullString1=null;
        String emptyString1="";
        modelMap.addAttribute("nullString1", nullString1);
        modelMap.addAttribute("emptyString1", emptyString1);
        modelMap.addAttribute("list1", Arrays.asList(1,2,3,4));
        modelMap.addAttribute("aggregates1", Arrays.asList(1,2,3,4));

        modelMap.addAttribute("myForm", new MyForm(new Date(), new Random().nextFloat()));

        return "utility-objects";
    }



}