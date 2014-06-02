package DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import util.HibernateUtil;
import DAO.CompanyDAO;
import Logic.Company;
import Logic.Director;

public class CompanyDAOImpl implements CompanyDAO
{

    @Override
    public int addCompany(Company company) throws HibernateException
    {
        Session session = null;
        Integer id = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            id = (Integer)session.save(company);
            session.getTransaction().commit();
            
        } finally
           {
              if (session != null && session.isOpen())
              {
                  session.close();
              }
           }
        return id.intValue();
    }
    

    @Override
    public void removeCompany(Company company) throws HibernateException
    {
        Session session = null;
        try
        {
            company.setIsRemoved(true);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(company);
            session.getTransaction().commit();
        }
        finally
        {
             if (session != null && session.isOpen())
              {
                  session.close();
              }
        }
        
    }

    @Override
    public void updateCompany(Company company) throws HibernateException
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(company);
            session.getTransaction().commit();
        }
        finally
        {
             if (session != null && session.isOpen())
              {
                  session.close();
              }
        }
        
    }

    @Override
    public Company getCompanyById(int id) throws HibernateException
    {

        Company company = null;
        Session session = null;
        try 
        {
            session = HibernateUtil.getSessionFactory().openSession();
            company = (Company)session.load(Company.class, id);
        } 
        finally 
        {
            if (session != null && session.isOpen()) 
            {
                session.close();
            }
        }
        return company;
    }

    @Override
    public List<Company> getAllCompanies() throws HibernateException
    {
        Session session = null;
        Criteria criteria = null;
        List<Company> companies = new ArrayList<Company>();
        
         try
         {  
             session = HibernateUtil.getSessionFactory().openSession();
      
             companies = session.createCriteria(Company.class).list();
         }
         finally
         {
             if (session != null && session.isOpen()) 
                {
                    session.close();
                }
         }
         return companies;
    }
    
}