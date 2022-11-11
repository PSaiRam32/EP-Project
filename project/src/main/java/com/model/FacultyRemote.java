package com.model;
import java.util.List;

import javax.ejb.Remote;

import com.entity.Faculty;

@Remote
public interface FacultyRemote 
{
  public String insertData(Faculty F)throws Exception;
  public List<Faculty> readAll() throws Exception;
  public Faculty findData(int id) throws Exception;
  public String updateData(int id, Faculty data)throws Exception;
  public String deleteData(int id) throws Exception;
}