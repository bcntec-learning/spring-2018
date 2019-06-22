package course.spring.mvc.errorhandling.sample3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class ExceptionHandlers extends BaseExceptionHandler {
    public ExceptionHandlers() {
        super(log);
    }

    @ExceptionHandler(InvoiceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleInvoiceNotFoundException(final InvoiceNotFoundException ex) {
        log.error("Invoice not found thrown", ex);
        return new ErrorResponse("INVOICE_NOT_FOUND", "The invoice was not found");
    }
}