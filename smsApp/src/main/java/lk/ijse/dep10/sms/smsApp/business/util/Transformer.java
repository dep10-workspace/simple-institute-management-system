package lk.ijse.dep10.sms.smsApp.business.util;

import lk.ijse.dep10.sms.smsApp.dto.StudentDTO;
import lk.ijse.dep10.sms.smsApp.entity.Student;
import org.modelmapper.ModelMapper;

public class Transformer {
    private final ModelMapper modelMapper;

    public Transformer(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Student toStudentEntity(StudentDTO studentDTO) {
        return modelMapper.map(studentDTO, Student.class);
    }

    public StudentDTO fromStudentEntity(Student student) {
        return modelMapper.map(student, StudentDTO.class);
    }
}
