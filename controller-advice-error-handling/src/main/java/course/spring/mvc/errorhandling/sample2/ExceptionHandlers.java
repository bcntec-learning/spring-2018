package course.spring.mvc.errorhandling.sample2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class ExceptionHandlers {


    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleAccountNotFoundException(final AccountNotFoundException ex) {
        log.error("Account not found thrown", ex);
        return new AccountResponse("ACCOUNT_NOT_FOUND", "The account was not found", ex.getId());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ErrorResponse handleThrowable(final Throwable ex) {
        log.error("Unexpected error", ex);
        return new ErrorResponse("INTERNAL_SERVER_ERROR", "An unexpected internal server error occured");
    }


    @Data
    @AllArgsConstructor
    public static class ErrorResponse {
        private final String code;
        private final String message;
    }

    @Data
    public static class AccountResponse extends ErrorResponse {
        private final Integer id;

        public AccountResponse(String code, String message, Integer id) {
            super(code, message);
            this.id = id;
        }
    }
}