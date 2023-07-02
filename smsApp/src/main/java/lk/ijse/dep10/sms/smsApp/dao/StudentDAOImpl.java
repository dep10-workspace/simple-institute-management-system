package lk.ijse.dep10.sms.smsApp.dao;

import static lk.ijse.dep10.sms.smsApp.dao.util.Mapper.STUDENT_ROW_MAPPER;
import lk.ijse.dep10.sms.smsApp.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
@Repository
public class StudentDAOImpl implements StudentDAO{
    private final JdbcTemplate jdbcTemplate;

    public StudentDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long count() throws Exception {
        return 0;
    }

    @Override
    public Student save(Student entity) throws Exception {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement stm = con.prepareStatement("INSERT INTO student(name, address) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            stm.setString(1,entity.getName());
            stm.setString(2,entity.getAddress());
            return stm;
        },keyHolder);
        entity.setId(keyHolder.getKey().intValue());
        return entity;
    }

    @Override
    public void update(Student entity) throws Exception {

    }

    @Override
    public void deleteById(Integer pk) throws Exception {
        jdbcTemplate.update("DELETE FROM student WHERE id=?", pk);
    }

    @Override
    public Optional<Student> findById(Integer pk) throws Exception {
        return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT *FROM student WHERE id=?",STUDENT_ROW_MAPPER, pk));
    }

    @Override
    public List<Student> findAll() throws Exception {
        return jdbcTemplate.query("SELECT *FROM student", STUDENT_ROW_MAPPER);
    }

    @Override
    public boolean existsById(Integer pk) throws Exception {
        if (findById(pk)!=null) return true;
        return false;
    }
}
