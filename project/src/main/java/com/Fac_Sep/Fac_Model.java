package com.Fac_Sep;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Faculty;






@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
public class Fac_Model implements Fac_Remote {


@Override
public Faculty ValidateData(int id,String password) throws Exception {
	 
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("klu");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Query qry=entityManager.createQuery("select u from Faculty u where id=? and  password=?");
    qry.setParameter(1, id);
    qry.setParameter(2, password);
    
   Faculty f = null;
    
    if (qry.getResultList().size()==1) 
    {
    	f = (Faculty) qry.getSingleResult();
    }
    
    entityManager.getTransaction().commit();
    
    entityManager.close();
    entityManagerFactory.close();
    
    return f;
}

@Override
public List<Faculty> readAll(int id,String password) throws Exception {
	 
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("klu");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    Query qry = em.createQuery("select f from Faculty f where id = ? and password = ?");
    qry.setParameter(1, id);
    qry.setParameter(2, password);
    @SuppressWarnings("unchecked")
    List<Faculty> L = qry.getResultList();
    em.getTransaction().commit();
    em.close();
    emf.close();
    return L;
  

  
}



}