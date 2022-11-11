package com.controller;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.entity.Admin;
import com.model.AdminRemote;

@ManagedBean(name="admin",eager=true)
public class AdminService {
     String username;
     String password;
     String response;
     String s;
     @EJB(lookup = "java:global/project/AdminModel!com.model.AdminRemote")
     AdminRemote AR;
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
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
  public String validate(){
	  
    try {
	 Admin A = AR.ValidateData(username, password);
	 if(A!=null) {
		 response = "admin_dashboard.xhtml";
	 }
	 else
		 response = "invalid.xhtml";
	 
    }catch(Exception e) {
    	response = e.getMessage();
    }
    return response;
}
}