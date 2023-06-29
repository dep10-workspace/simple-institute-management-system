package lk.ijse.dep10.sms.smsApp.business;

import lk.ijse.dep10.sms.smsApp.dto.StudentDTO;

import java.util.List;

public interface StudentBO {
    StudentDTO saveStudent(StudentDTO studentDTO) throws Exception;

    List<StudentDTO> getAllStudents() throws Exception;

    void deleteStudentByStudentId(int studentId) throws Exception;
}
