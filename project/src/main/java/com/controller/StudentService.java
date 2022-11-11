package com.controller;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.entity.Student;
import com.model.StudentRemote;

@ManagedBean(name= "student", eager = true)
public class StudentService {
  int id;
  String name;
  String course;
  String cgpa;
  String Att;
  String response;
  String password;
  
  List<Student> list;
  @EJB(lookup = "java:global/project/StudentModel!com.model.StudentRemote")
  StudentRemote SR;
  


  public List<Student> getList() {
    try {
      list = SR.readAll();
    }
    catch(Exception e)
    {
      response = e.getMessage();
    }
    return list;
  }

  public void setList(List<Student> list) {
    this.list = list;
  }
  public void delete()
  {
    try
    {
      response = SR.deleteData(id);
    }catch(Exception e)
    {
      response = e.getMessage();
    }
  }
  
  public void update()
  {
    try
    {
      Student S=new Student();
      S.setId(id);
      S.setName(name);
      S.setCourse(course);
      S.setCgpa(cgpa);
      S.setAtt(Att);
      S.setPassword(password);
      
      
      response = SR.updateData(id, S);
      
    }catch(Exception e)
    {
      response = e.getMessage();
    }
  }
  
  public void find()
  {
    try
    {
      Student S= SR.findData(id);
     id=  S.getId();
     password=S.getPassword();
     name= S.getName();
      course=S.getCourse();
      cgpa=S.getCgpa();
      Att=S.getAtt();
      
    }catch(Exception e)
    {
      response = e.getMessage();
    }
  }
  
  public void insert()
  {
    try 
    {
      Student S=new Student();
      S.setId(id);
      S.setName(name);
      S.setCourse(course);
      S.setCgpa(cgpa);
      S.setAtt(Att);
      S.setPassword(password);

      response = SR.insertData(S);
    } catch (Exception e) 
    {
      response = e.getMessage();
    }
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCourse() {
    return course;
  }

  public void setCourse(String course) {
    this.course = course;
  }


  public String getAtt() {
    return Att;
  }

  public void setAtt(String att) {
    Att = att;
  }

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

public void setCgpa(String cgpa) {
	this.cgpa = cgpa;
}

public String getCgpa() {
	return cgpa;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

  
  

}