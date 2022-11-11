package com.model;

import java.util.List;

import com.entity.Student;

public interface StudentRemote {
  
  public String insertData(Student S)throws Exception;
  public List<Student> readAll() throws Exception;
  public Student findData(int id) throws Exception;
  public String updateData(int id, Student data)throws Exception;
  public String deleteData(int id) throws Exception;

}