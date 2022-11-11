package com.controller;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.entity.Faculty;
import com.model.FacultyRemote;

@ManagedBean(name= "faculty", eager = true)
public class FacultyService {
  int id;
  String name;
  String dsg;
  String ach;
  String course;
  String response;
  String password;
  
  List<Faculty> list;
  @EJB(lookup = "java:global/project/FacultyModel!com.model.FacultyRemote")
  FacultyRemote FR;

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

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }
  public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

  public List<Faculty> getList() {
    try {
      list = FR.readAll();
    }
    catch(Exception e)
    {
      response = e.getMessage();
    }
    return list;
  }

  public void setList(List<Faculty> list) {
    this.list = list;
  }
  public void delete()
  {
    try
    {
      response = FR.deleteData(id);
    }catch(Exception e)
    {
      response = e.getMessage();
    }
  }
  
  public void update()
  {
    try
    {
      Faculty E=new Faculty();
      E.setId(id);
      E.setPassword(password);
      E.setName(name);
      E.setDsg(dsg);
      E.setAch(ach);
      E.setCourse(course);
     
      
      
      
      response = FR.updateData(id, E);
      
    }catch(Exception e)
    {
      response = e.getMessage();
    }
  }
  
  public void find()
  {
    try
    {
      Faculty E = FR.findData(id);
      id = E.getId();
      password= E.getPassword();
      name = E.getName();
      course = E.getCourse();
      dsg = E.getDsg();
      ach = E.getAch();
           
    }catch(Exception e)
    {
      response = e.getMessage();
    }
  }
  
  public void insert()
  {
    try 
    {
      Faculty F=new Faculty();
      F.setId(id);
      F.setPassword(password);
      F.setName(name);
      F.setDsg(dsg);
      F.setAch(ach);
      F.setCourse(course);
      
     

      response = FR.insertData(F);
    } catch (Exception e) 
    {
      response = e.getMessage();
    }
  }



}