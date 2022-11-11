package com.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student implements Serializable{

  private static final long serialVersionUID = 1L;
  
  @Id
  int id;
  String name;
  String course;
  String cgpa;
  String Att;
  String password;
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
public String getCgpa() {
	return cgpa;
}
public void setCgpa(String cgpa) {
	this.cgpa = cgpa;
}


public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
  
  
  

}