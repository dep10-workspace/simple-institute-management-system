package lk.ijse.dep10.sms.smsApp.api;

import lk.ijse.dep10.sms.smsApp.business.StudentBO;
import lk.ijse.dep10.sms.smsApp.dto.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO) throws Exception {
        System.out.println("Save");
        return studentBO.saveStudent(studentDTO);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable("id") int id) throws Exception {
        System.out.println("Delete");
        studentBO.deleteStudentByStudentId(id);
    }

}
