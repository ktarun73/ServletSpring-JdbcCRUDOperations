package com.DAO;

import com.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentDaoImplementation implements StudentDao {

    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> getStudents() {
        String query="select * from student";
        RowMapperImplementation rowMapper=new RowMapperImplementation();
        List<Student> students=this.jdbcTemplate.query(query,rowMapper);
        return students;
    }

    @Override
    public Student getStudent(int id) {
        String query="select * from student where id=?";
        RowMapperImplementation rowMapper=new RowMapperImplementation();
        Student student=this.jdbcTemplate.queryForObject(query,rowMapper,id);
        return student;
    }

    @Override
    public int insert(Student student) {
        String query="insert into student value(?,?,?)";
        int res=jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return res;
    }

    @Override
    public int delete(int id) {
        String query="delete from student where id=?";
        int res=this.jdbcTemplate.update(query,id);
        return res;
    }

    @Override
    public int update(int id,String update,String value) {
        String query="update student set "+update+" = ? where id=?";
        int res=this.jdbcTemplate.update(query,value,id);
        return res;
    }
}
