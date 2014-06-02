package DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;
import DAO.CopyDAO;
import Logic.Copy;
import Logic.CopyType;
import Logic.Movie;

public class CopyDAOImpl implements CopyDAO
{


    @Override
    public void updateCopy(Copy copy) throws HibernateException
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(copy);
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
    public List<Copy> getCopiesByMovie(Movie movie)
            throws HibernateException
    {
        Session session = null;
        Criteria criteria = null;
        List<Copy> copies = new ArrayList<Copy>();
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            criteria = session.createCriteria(Copy.class);
            if (movie != null)
            {
                criteria = criteria.add(Restrictions.eq("movie", movie));
                
            }
            
           copies = criteria.list();   
        }
        finally
        {
            if (session != null && session.isOpen()) 
            {
                session.close();
            }
        }
        return copies;
    }

    @Override
    public List<Copy> getAllCopies() throws HibernateException
    {
        Session session = null;
        
        List<Copy> copies = new ArrayList<Copy>();
        
         try
         {  
             session = HibernateUtil.getSessionFactory().openSession();
             copies =session.createCriteria(Copy.class).list();
         }
         finally
         {
             if (session != null && session.isOpen()) 
                {
                    session.close();
                }
         }
         return copies;
    }
    
    @Override
    public Copy getCopyById(int id) throws HibernateException
    {
        Copy copy = null;
        Session session = null;
        try 
        {
            session = HibernateUtil.getSessionFactory().openSession();
            copy = (Copy)session.load(Copy.class, id);
        } 
        finally 
        {
            if (session != null && session.isOpen()) 
            {
                session.close();
            }
        }
        return copy;
    }
    
    public Copy getCopiesByMovieType(Movie movie, CopyType copyType)throws HibernateException
    {
      Copy copy;
      Session session = null;
      Criteria criteria = null;
      try
      {
          session = HibernateUtil.getSessionFactory().openSession();
          criteria = session.createCriteria(Copy.class);
          criteria = criteria.add(Restrictions.eq("movie", movie));
          criteria = criteria.add(Restrictions.eq("copyType", copyType));  
          copy = (Copy)criteria.list().get(0);   
      }
      finally
      {
          if (session != null && session.isOpen()) 
          {
              session.close();
          }
      }
      return copy;
     
    } 
    
    public void addCopy(Copy copy) throws HibernateException
    {
        Session session = null;
        Integer id = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            id = (Integer)session.save(copy);
            session.getTransaction().commit();
            
        } finally
           {
              if (session != null && session.isOpen())
              {
                  session.close();
              }
           }
        return;
    }
    
    
    
}