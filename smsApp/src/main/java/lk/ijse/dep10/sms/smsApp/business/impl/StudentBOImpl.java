package lk.ijse.dep10.sms.smsApp.business.impl;

import lk.ijse.dep10.sms.smsApp.business.StudentBO;
import lk.ijse.dep10.sms.smsApp.business.util.Transformer;
import lk.ijse.dep10.sms.smsApp.dao.StudentDAO;
import lk.ijse.dep10.sms.smsApp.dto.StudentDTO;
import lk.ijse.dep10.sms.smsApp.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentBOImpl implements StudentBO {
    private final StudentDAO studentDAO;
    private final Transformer transformer;

    public StudentBOImpl(StudentDAO studentDAO, Transformer transformer) {
        this.studentDAO = studentDAO;
        this.transformer = transformer;
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) throws Exception {
        Student studentEntity = studentDAO.save(transformer.toStudentEntity(studentDTO));
        return transformer.fromStudentEntity(studentEntity);
    }

    @Override
    public List<StudentDTO> getAllStudents() throws Exception {
        return studentDAO.findAll().stream().map((entity)->transformer.fromStudentEntity(entity)).collect(Collectors.toList());
    }

    @Override
    public void deleteStudentByStudentId(int studentId) throws Exception {
        studentDAO.deleteById(studentId);
    }
}
