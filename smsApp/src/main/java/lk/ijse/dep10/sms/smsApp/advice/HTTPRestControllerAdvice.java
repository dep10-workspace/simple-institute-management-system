package lk.ijse.dep10.sms.smsApp.advice;

import lk.ijse.dep10.sms.smsApp.business.util.BusinessException;
import lk.ijse.dep10.sms.smsApp.business.util.BusinessExceptionType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class HTTPRestControllerAdvice {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Map<String, Object>> handleBusinessExceptions(BusinessException exp) {
        Map<String, Object> errorAttributes = new HashMap<>();
        if (exp.getType() == BusinessExceptionType.RECORD_NOT_FOUND) {
            errorAttributes = getCommonErrorAttributes(HttpStatus.NOT_FOUND);
        } else {
            errorAttributes = getCommonErrorAttributes(HttpStatus.INTERNAL_SERVER_ERROR);
            exp.printStackTrace();
        }
        errorAttributes.put("message", exp.getMessage());
        return new ResponseEntity<>(errorAttributes, HttpStatus.valueOf((Integer) errorAttributes.get("status")));
    }

    @ExceptionHandler(
            {MethodArgumentNotValidException.class,
            ConstraintViolationException.class,
            MethodArgumentTypeMismatchException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleValidationExceptions(Exception exp) {
        Map<String, Object> errorAttributes = getCommonErrorAttributes(HttpStatus.BAD_REQUEST);
        if (exp instanceof MethodArgumentNotValidException) {
            ArrayList<Map<String,Object>> errorList = new ArrayList<>();
            MethodArgumentNotValidException mExp= (MethodArgumentNotValidException) exp;
            mExp.getFieldErrors().forEach(fieldError -> {
                HashMap<String, Object> error = new HashMap<>();
                error.put("field", fieldError.getField());
                error.put("rejectedValue", fieldError.getRejectedValue());
                error.put("message", fieldError.getDefaultMessage());
                errorList.add(error);
            });
            errorAttributes.put("message", "Data Validation Failed");
            errorAttributes.put("errors", errorList);
        }else if (exp instanceof ConstraintViolationException){
            ConstraintViolationException mExp = (ConstraintViolationException) exp;
            ArrayList<Map<String,Object>> errorList = new ArrayList<>();

            mExp.getConstraintViolations().forEach(fieldError -> {
                HashMap<String, Object> error = new HashMap<>();
                error.put("rejectedValue", fieldError.getInvalidValue());
                error.put("message", fieldError.getMessage());
                errorList.add(error);
            });

            errorAttributes.put("message", "Data Validation Failed");
            errorAttributes.put("errors", errorList);
        }else {
            MethodArgumentTypeMismatchException mExp = (MethodArgumentTypeMismatchException) exp;
            errorAttributes.put("message", "Invalid Data passed to "+mExp.getName());
        }
        return errorAttributes;
    }
    @ExceptionHandler(Throwable.class)
    public Map<String, Object> handleExceptions(Throwable t) {
        Map<String, Object> errorAttributes = getCommonErrorAttributes(HttpStatus.INTERNAL_SERVER_ERROR);
        errorAttributes.put("message", t.getMessage());
        t.printStackTrace();
        return errorAttributes;
    }

    public Map<String, Object> getCommonErrorAttributes(HttpStatus status) {
        LinkedHashMap<String, Object> errorAttributes = new LinkedHashMap<>();
        errorAttributes.put("timestamp", LocalDateTime.now());
        errorAttributes.put("status", status.value());
        errorAttributes.put("error", status);
        return errorAttributes;
    }

}
