package course.spring.mvc.kendo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Data
public class Person {
    private Long id;
    private String firstName;
    private String lastName;


    static List<Person> persons = new ArrayList<>();
    static {;
        persons.add(new Person(1L, "Name 1", "Last 1"));
        persons.add(new Person(2L, "Name 2", "Last 2"));
        persons.add(new Person(3L, "Name 3", "Last 3"));
        persons.add(new Person(4L, "Name 4", "Last 4"));
    }
    public static List<Person> all(){
        return persons;
    }

    public static Person find(Long id){
        Optional<Person> o = persons.stream().filter(p->p.getId().equals(id)).findFirst();
        return o.isPresent() ? o.get() : null;
    }

    public static Person remove(Long id){
        Person p = find(id);
        if(p!=null){
            persons.remove(p);
        }
        return p;
    }

    public static void add(Person p) {
         persons.add(p);
    }
}
