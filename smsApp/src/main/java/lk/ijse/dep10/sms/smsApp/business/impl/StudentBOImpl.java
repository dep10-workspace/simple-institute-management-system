package lk.ijse.dep10.sms.smsApp.business.impl;

import lk.ijse.dep10.sms.smsApp.business.StudentBO;
import lk.ijse.dep10.sms.smsApp.business.util.Transformer;
import lk.ijse.dep10.sms.smsApp.dao.StudentDAO;
import lk.ijse.dep10.sms.smsApp.dto.StudentDTO;

import java.util.List;
import java.util.stream.Collectors;

public class StudentBOImpl implements StudentBO {
    private final StudentDAO studentDAO;
    private final Transformer transformer;

    public StudentBOImpl(StudentDAO studentDAO, Transformer transformer) {
        this.studentDAO = studentDAO;
        this.transformer = transformer;
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) throws Exception {
        studentDAO.save(transformer.toStudentEntity(studentDTO));
        return studentDTO;
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
