package course.spring.mvc.errorhandling.sample2;

import lombok.Getter;

public class AccountNotFoundException extends RuntimeException {
    @Getter
    private Integer id;

    public AccountNotFoundException(Integer id) {
        this.id = id;
    }

}