package DAO.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;
import DAO.OrderHistoryDAO;
import Logic.Client;
import Logic.Movie;
import Logic.OrderHistory;


public class OrderHistoryDAOImpl implements OrderHistoryDAO
{

    @Override
    public int addOrderHistory(OrderHistory orderHistory)
            throws HibernateException
    {
        Session session = null;
        Integer id = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            id = (Integer)session.save(orderHistory);
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
    public void removeOrderHistory(OrderHistory orderHistory)
            throws HibernateException
    {
        Session session = null;
        try
        {
            orderHistory.setIsRemoved(true);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(orderHistory);
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
    public void updateOrderHistory(OrderHistory orderHistory)
            throws HibernateException
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(orderHistory);
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
    public OrderHistory getOrderHistoryById(int id) throws HibernateException
    {
        OrderHistory orderHistory = null;
        Session session = null;
        try 
        {
            session = HibernateUtil.getSessionFactory().openSession();
            orderHistory = (OrderHistory)session.load(OrderHistory.class, id);
        } 
        finally 
        {
            if (session != null && session.isOpen()) 
            {
                session.close();
            }
        }
        return orderHistory;
    }

    @Override
    public List<OrderHistory> getOrderHistoryByFilter(Client client, Date beginDate, Date endDate, Movie movie, int opened)
            throws HibernateException
    {
      Session session = null;
      Criteria criteria = null;
      List<OrderHistory> orderHistory = new ArrayList<OrderHistory>();
      try
      {
          session = HibernateUtil.getSessionFactory().openSession();
          criteria =session.createCriteria(OrderHistory.class);
     
          if (client != null)
          {
              criteria.add(Restrictions.eq("client", client));       
          }
          if (movie != null)
          {
              criteria = criteria.add(Restrictions.eq("movie", movie));
          }
          if (opened==1)
          {
              criteria = criteria.add(Restrictions.isNull("returnTime")); 
          }
          if (opened==0)
          {
              criteria = criteria.add(Restrictions.isNotNull("returnTime"));  
          }
          orderHistory = criteria.list();  
      }
      finally
      {
          if (session != null && session.isOpen()) 
          {
              session.close();
          }
      }
     
      
      return orderHistory;
    }

    @Override
    public List<OrderHistory> getAllOrderHistory() throws HibernateException
    {
        Session session = null;
        
        List<OrderHistory> orderHistory = new ArrayList<OrderHistory>();
        
         try
         {  
             session = HibernateUtil.getSessionFactory().openSession();
             orderHistory =session.createCriteria(OrderHistory.class).list();
         }
         finally
         {
             if (session != null && session.isOpen()) 
                {
                    session.close();
                }
         }
         return orderHistory;
    }
    
}