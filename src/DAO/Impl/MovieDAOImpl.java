package DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;
import DAO.MovieDAO;
import Logic.Client;
import Logic.Company;
import Logic.Director;
import Logic.Movie;

public class MovieDAOImpl implements MovieDAO
{

    @Override
    public int addMovie(Movie movie) throws HibernateException
    {
        Session session = null;
        Integer id = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            id = (Integer)session.save(movie);
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
    public void removeMovie(Movie movie) throws HibernateException
    {
        Session session = null;
        try
        {
            movie.setIsRemoved(true);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(movie);
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
    public void updateMovie(Movie movie) throws HibernateException
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(movie);
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
    public Movie getMovieById(int id) throws HibernateException
    {
        Movie movie = null;
        Session session = null;
        try 
        {
            session = HibernateUtil.getSessionFactory().openSession();
            movie = (Movie)session.load(Movie.class, id);
        } 
        finally 
        {
            if (session != null && session.isOpen()) 
            {
                session.close();
            }
        }
        return movie;
    }

    @Override
    public List<Movie> getMoviesByFilter(String name, Client client,Director director, Company company, int year)
            throws HibernateException
    {
        Session session = null;
        Criteria criteria = null;
        List<Movie> movies = new ArrayList<Movie>();
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            criteria = session.createCriteria(Movie.class);
            if (name != null)
            {
               criteria = criteria.add(Restrictions.like("title", "%"+name+"%"));
            }
            if (client != null)
            {
               criteria = criteria.createAlias("historyFilms", "hf");
               criteria.add(Restrictions.eq("hf.client", client));
            } 
            if (director != null)
            {
                criteria.add(Restrictions.eq("director", director));
            }
            if (company != null)
            {
                criteria.add(Restrictions.eq("company", company));
            }   
            if (year > 0)
            {
                criteria.add(Restrictions.eq("year", year));
            }
            criteria.add(Restrictions.eq("isRemoved", false));
         movies = criteria.addOrder(Order.asc("title")).list();   
        }
        finally
        {
            if (session != null && session.isOpen()) 
            {
                session.close();
            }
        }
        return movies;
    }

    @Override
    public List<Movie> getAllMovies() throws HibernateException
    {
        Session session = null;
        Criteria criteria = null;
        List<Movie> movies = new ArrayList<Movie>();
        
         try
         {   session = HibernateUtil.getSessionFactory().openSession();
             criteria = session.createCriteria(Movie.class);
             criteria.add(Restrictions.eq("isRemoved", false));
             movies = criteria.addOrder(Order.asc("title")).list();  
         }
         finally
         {
             if (session != null && session.isOpen()) 
                {
                    session.close();
                }
         }
         return movies;
    }
    
}