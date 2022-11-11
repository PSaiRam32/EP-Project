package com.model;

import java.util.List;

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
public class StudentModel implements StudentRemote 
{

  @Override
  public String insertData(Student S) throws Exception 
  {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("klu");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(S);
    em.getTransaction().commit();
    em.close();
    emf.close();
    return "Record inserted succesfylly...";
  }

  @Override
  public List<Student> readAll() throws Exception 
  {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("klu");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    Query qry = em.createQuery("select f from Student f");
    @SuppressWarnings("unchecked")
    List<Student> L = qry.getResultList();
    em.getTransaction().commit();
    em.close();
    emf.close();
    return L;
  }

  @Override
  public Student findData(int id) throws Exception 
  {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("klu");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    Student F = em.find(Student.class, id);
    em.getTransaction().commit();
    em.close();
    emf.close();
    return F;
  }

  @Override
  public String updateData(int id, Student data) throws Exception 
  {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("klu");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    Student E = em.find(Student.class, id);
    E.setId(data.getId());
    E.setName(data.getName());
    E.setCourse(data.getCourse());
    E.setCgpa(data.getCgpa());
    E.setAtt(data.getAtt());
    E.setPassword(data.getPassword());
    em.getTransaction().commit();
    em.close();
    emf.close();
    return "Record updated successfully...";
  }

  @Override
  public String deleteData(int id) throws Exception 
  {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("klu");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    Student F = em.find(Student.class, id);
    em.remove(F);
    em.getTransaction().commit();
    em.close();
    emf.close();
    return "Record deleted successfully...";
  }

}