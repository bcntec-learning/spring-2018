package course.spring.mvc.thymeleaf.simple;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class ConversionsController {



    @GetMapping("/conversions")
    public String iterations(ModelMap modelMap) {
        modelMap.addAttribute("myForm1", new MyForm(new Date(), new Random().nextFloat()));

        return "conversions";
    }


    @PostMapping("/conversions")
    public String iterations(@ModelAttribute("userForm") UserForm userForm, ModelMap modelMap) {

        return "conversions";
    }

    @ModelAttribute("conversionsVal1")
    private BigDecimal val1(){
        return new BigDecimal(new Random().nextFloat());
    }

    @ModelAttribute("conversionsDate1")
    private Date date1(){
        return new Date();
    }

    @ModelAttribute("conversionsUser1")
    private User user1(){
        return new User(1L,"name","email1@domain");
    }

    @ModelAttribute("conversionsItem1")
    private Item item1(){
        return new Item(val1().multiply(BigDecimal.valueOf(100L)),val1().multiply(BigDecimal.valueOf(10L)));
    }

}