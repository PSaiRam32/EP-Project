package com.Fac_Sep;
import java.util.List;

import javax.ejb.Remote;

import com.entity.Faculty;

@Remote
public interface Fac_Remote {
 public Faculty ValidateData(int id,String password) throws Exception;
public List<Faculty> readAll(int id, String password) throws Exception;
}
