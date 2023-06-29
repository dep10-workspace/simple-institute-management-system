package lk.ijse.dep10.sms.smsApp.business;

import lk.ijse.dep10.sms.smsApp.dto.StudentDTO;

import java.io.Serializable;
import java.util.List;

public interface StudentBO extends Serializable {
    StudentDTO saveStudent(StudentDTO studentDTO) throws Exception;

    List<StudentDTO> getAllStudents() throws Exception;

    void deleteStudentByStudentId(int studentId) throws Exception;
}
