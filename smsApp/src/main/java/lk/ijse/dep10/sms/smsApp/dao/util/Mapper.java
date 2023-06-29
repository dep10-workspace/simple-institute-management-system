package lk.ijse.dep10.sms.smsApp.dao.util;

import lk.ijse.dep10.sms.smsApp.entity.Student;
import org.springframework.jdbc.core.RowMapper;

public class Mapper {

    public static final RowMapper<Student> STUDENT_ROW_MAPPER=((rs, rowNum) -> {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String address = rs.getString("address");
        return new Student(id,name,address);
    });
}
