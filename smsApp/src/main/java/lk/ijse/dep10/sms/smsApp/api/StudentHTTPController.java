package lk.ijse.dep10.sms.smsApp.api;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/students")
public class StudentHTTPController {
    @GetMapping
    public String getAllStudents() {
        System.out.println("GetAll");
        return "<h1>GetAll</h1>";
    }
    @PostMapping(consumes = "application/json")
    public String saveStudent() {
        System.out.println("Save");
        return "<h1>Save</h1>";
    }
    @DeleteMapping("/{id}")
    public String deleteStudent() {
        System.out.println("Delete");
        return "<h1>Delete</h1>";
    }

}
