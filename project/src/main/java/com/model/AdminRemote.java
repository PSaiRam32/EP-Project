package com.model;
import javax.ejb.Remote;
import com.entity.Admin;
@Remote
public interface AdminRemote {
 public Admin ValidateData(String uername,String password) throws Exception;
}
