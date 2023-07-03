package lk.ijse.dep10.sms.smsApp.api;

import lk.ijse.dep10.sms.smsApp.business.StudentBO;
import lk.ijse.dep10.sms.smsApp.business.util.BusinessException;
import lk.ijse.dep10.sms.smsApp.dto.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/students")
public class StudentHTTPController {
    private final StudentBO studentBO;

    public StudentHTTPController(StudentBO studentBO) {
        this.studentBO = studentBO;
    }


    @GetMapping
    public List<StudentDTO> getAllStudents() throws Exception {
        System.out.println("GetAll");
        return studentBO.getAllStudents();
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO saveStudent(@RequestBody @Valid StudentDTO studentDTO) throws Exception {
        System.out.println("Save");
        return studentBO.saveStudent(studentDTO);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable("id") @Valid int id) throws Exception {
        System.out.println("Delete");
        studentBO.deleteStudentByStudentId(id);
    }

}
