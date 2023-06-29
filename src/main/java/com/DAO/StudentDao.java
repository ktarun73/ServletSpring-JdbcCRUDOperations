package com.DAO;

import com.entity.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> getStudents();
    public Student getStudent(int id);
    public int insert(Student student);
    public int delete(int id);
    public int update(int id,String update,String value);
}
