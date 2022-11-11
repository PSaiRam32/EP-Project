package com.Stu_Sep;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Student;

@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
public class Stu_Model implements Stu_Remote {


public Student ValidateData(int id,String password) throws Exception {
	 
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("klu");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Query qry=entityManager.createQuery("select u from Student u where id=? and  password=?");
    qry.setParameter(1, id);
    qry.setParameter(2, password);
    
   Student f = null;
    
    if (qry.getResultList().size()==1) 
    {
    	f = (Student) qry.getSingleResult();
    }
    
    entityManager.getTransaction().commit();
    
    entityManager.close();
    entityManagerFactory.close();
    
    return f;

  
}



}