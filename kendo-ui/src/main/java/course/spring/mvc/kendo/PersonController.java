package course.spring.mvc.kendo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller("/persons")
public class PersonController {



    @ResponseBody
    @GetMapping("/persons")
    public List<Person> get(){
        return Person.all();
    }

    @ResponseBody
    @GetMapping(value = "/person", params = {"id"})
    public Person find(@RequestParam("id") Long id){
        return Person.find(id);
    }

    @ResponseBody
    @GetMapping(value = "/person/delete", params = {"id"})
    public Person delete(@RequestParam("id") Long id){
        return Person.remove(id);
    }

    @ResponseBody
    @PostMapping(value = "/person/add")
    public Person add(@RequestBody  Person p){
         Person.add(p);
         return Person.find(p.getId());
    }
    @ResponseBody
    @PostMapping(value = "/person/update")
    public Person update(Model m){

        Person a = Person.find((new Long((String)m.asMap().get("id"))));
        if(a!=null) {
            a.setFirstName((String)m.asMap().get("fistName"));
            a.setLastName((String)m.asMap().get("lastName"));
        }
        return a;
    }
}
