package com.Fac_Sep;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.entity.Faculty;


@ManagedBean(name="fac",eager=true)
public class Fac_Sep_Service {
	  int id;
	  String name;
	  String dsg;
	  String ach;
	  String course;
     String password;
     String response;
     List<Faculty> list;
     
     @EJB(lookup = "java:global/project/Fac_Model!com.Fac_Sep.Fac_Remote")
     Fac_Remote FL;

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
			 Faculty f = FL.ValidateData(id, password);
			 if(f!=null) {
				 response = "faculty_dashboard.xhtml";
			 }
			 else
				 response = "invalidf.xhtml";
			 
		    }catch(Exception e) {
		    	response = e.getMessage();
		    }
		    return response;

}
public List<Faculty> getList() {
	try {
		list = FL.readAll(id, password);
	}
	catch(Exception e) {
		response = e.getMessage();
	}
	return list;
}
public void setList(List<Faculty> list) {
	this.list = list;
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
}