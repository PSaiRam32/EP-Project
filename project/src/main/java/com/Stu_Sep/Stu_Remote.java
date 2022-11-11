package com.Stu_Sep;


import javax.ejb.Remote;

import com.entity.Student;

@Remote
public interface Stu_Remote {
 public Student ValidateData(int id,String password) throws Exception;
}
