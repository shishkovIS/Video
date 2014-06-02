package DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import DAO.ClientDAO;
import Logic.Client;
import Logic.Movie;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;
import Logic.Movie;
public class ClientDAOImpl implements ClientDAO
{
	public int addClient(Client client) throws HibernateException
	{
		Session session = null;
		Integer id = null;
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			id = (Integer)session.save(client);
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

	
	public void removeClient(Client client) throws HibernateException {
		Session session = null;
		try
		{
		    client.setIsRemoved(true);
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			session.update(client);
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


	public void updateClient(Client client) throws HibernateException {
	    Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(client);
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

	
	public Client getClientById(int id) throws HibernateException {
		Client client = null;
		Session session = null;
		try 
		{
			session = HibernateUtil.getSessionFactory().openSession();
			client = (Client)session.load(Client.class, id);
		} 
		finally 
		{
			if (session != null && session.isOpen()) 
			{
				session.close();
			}
		}
		return client;
	}

    
	public List<Client> getClientsByFilter(String name, Movie movie) throws HibernateException
	{
		Session session = null;
		Criteria criteria = null;
		List<Client> clients = new ArrayList<Client>();
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			criteria = session.createCriteria(Client.class);
			if (name != null)
			{
			   criteria.add(Restrictions.like("name", "%"+name+"%"));
			}
			if (movie != null)
			{
			     
			      criteria.createAlias("historyRecords", "hr");
	              criteria.add(Restrictions.eq("hr.movie", movie));
			} 
			
		   clients = criteria.addOrder(Order.asc("name")).list();	
		}
		finally
		{
			if (session != null && session.isOpen()) 
			{
				session.close();
			}
		}
		return clients;
	}



	public List<Client> getAllClients() throws HibernateException 
	{
		Session session = null;
	    Criteria criteria = null;
		List<Client> clients = new ArrayList<Client>();
		
		 try
		 {	
			 session = HibernateUtil.getSessionFactory().openSession();
			 criteria = session.createCriteria(Client.class);
			 criteria.add(Restrictions.eq("isRemoved", false));
			 clients = criteria.addOrder(Order.asc("name")).list();  
		 }
		 finally
		 {
			 if (session != null && session.isOpen()) 
				{
					session.close();
				}
		 }
		 return clients;
	}
}