package com.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty implements Serializable{

  private static final long serialVersionUID = 1L;
  
  @Id
  int id;
  String name;
  String dsg;
  String ach;
  String course;
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
  public String getDsg() {
    return dsg;
  }
  public void setDsg(String dsg) {
    this.dsg = dsg;
  }
  public String getAch() {
    return ach;
  }
  public void setAch(String ach) {
    this.ach = ach;
  }
  public String getCourse() {
    return course;
  }
  public void setCourse(String course) {
    this.course = course;
  }
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}



}