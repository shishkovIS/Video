package DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import util.HibernateUtil;
import DAO.DirectorDAO;
import Logic.Client;
import Logic.Director;
import Logic.Movie;

public class DirectorDAOImpl implements DirectorDAO
{

	@Override
	public int addDirector(Director director) throws HibernateException
	{
		Session session = null;
		Integer id = null;
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			id = (Integer)session.save(director);
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
	public void removeDirector(Director director) throws HibernateException 
	{
		Session session = null;
		try
		{
		    director.setIsRemoved(true);
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(director);
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
	public void updateDirector(Director director) throws HibernateException
	{
		Session session = null;
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(director);
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
	public Director getDirectorById(int id) throws HibernateException 
	{
		Director director = null;
		Session session = null;
		try 
		{
			session = HibernateUtil.getSessionFactory().openSession();
			director = (Director)session.load(Director.class, id);
		} 
		finally 
		{
			if (session != null && session.isOpen()) 
			{
				session.close();
			}
		}
		return director;
	}



	@Override
	public List<Director> getAllDirectors() throws HibernateException 
	{
	    Session session = null;
        Criteria criteria = null;
        List<Director> directors = new ArrayList<Director>();
        
         try
         {  
             session = HibernateUtil.getSessionFactory().openSession();
  
             directors = session.createCriteria(Director.class).list();
         }
         finally
         {
             if (session != null && session.isOpen()) 
                {
                    session.close();
                }
         }
         return directors;
	}
   
}