package com.Stu_Sep;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.entity.Student;


@ManagedBean(name="stu",eager=true)
public class Stu_Service {
	  int id;
	  String name;
	  String course;
	  String cgpa;
	  String att;
     String password;
     
     String response;
   
     
     @EJB(lookup = "java:global/project/Stu_Model!com.Stu_Sep.Stu_Remote")
      Stu_Remote FL;

  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getResponse() {
    return response;
  }
  public void setResponse(String response) {
    this.response = response;
  }
  public String validateData(){
	  try {
			 Student f = FL.ValidateData(id, password);
			 if(f!=null) {
				 response = "student_dashboard.xhtml";
			 }
			 else
				 response = "invalidf.xhtml";
			 
		    }catch(Exception e) {
		    	response = e.getMessage();
		    }
		    return response;

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
public String getCgpa() {
	return cgpa;
}
public void setCgpa(String cgpa) {
	this.cgpa = cgpa;
}
public String getAtt() {
	return att;
}
public void setAtt(String att) {
	this.att = att;
}
}