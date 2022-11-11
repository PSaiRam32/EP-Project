package com.model;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Admin;


@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
public class AdminModel implements AdminRemote {


@Override
public Admin ValidateData(String username,String password) throws Exception {
	 
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("klu");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Query qry=entityManager.createQuery("select u from Admin u where username=? and  password=?");
    qry.setParameter(1, username);
    qry.setParameter(2, password);
    
    Admin u = null;
    
    if (qry.getResultList().size()==1) 
    {
    	u = (Admin) qry.getSingleResult();
    }
    
    entityManager.getTransaction().commit();
    
    entityManager.close();
    entityManagerFactory.close();
    
    return u;
}

}