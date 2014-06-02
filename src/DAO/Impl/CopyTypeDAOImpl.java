package DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;
import DAO.CopyTypeDAO;
import DAO.DirectorDAO;
import Logic.Client;
import Logic.Copy;
import Logic.CopyType;
import Logic.Director;
import Logic.Movie;

public class CopyTypeDAOImpl implements CopyTypeDAO
{

 
    public List<CopyType> getAllCopyTypes() throws HibernateException
    {
        Session session = null;
        Criteria criteria = null;
        List<CopyType> copyTypes = new ArrayList<CopyType>();
        
         try
         {      session = HibernateUtil.getSessionFactory().openSession();
         
                copyTypes = session.createCriteria(CopyType.class).list(); 
         }
         finally
         {
             if (session != null && session.isOpen()) 
                {
                    session.close();
                }
         }
         return copyTypes;
    }
    public CopyType getCopyTypeById(int id) throws HibernateException
    {
        CopyType copyType = null;
        Session session = null;
        try 
        {
            session = HibernateUtil.getSessionFactory().openSession();
            copyType = (CopyType)session.load(CopyType.class, id);
        } 
        finally 
        {
            if (session != null && session.isOpen()) 
            {
                session.close();
            }
        }
        return copyType;
    }
}