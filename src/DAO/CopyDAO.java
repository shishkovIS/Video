package DAO;

import Logic.Copy;
import Logic.CopyType;
import Logic.Movie;


import java.util.List;


import org.hibernate.HibernateException;

public interface CopyDAO {
  
    public void updateCopy(Copy copy) throws HibernateException;

    public List<Copy> getCopiesByMovie(Movie movie) throws HibernateException;
    public List<Copy> getAllCopies() throws HibernateException;
    public Copy getCopyById(int id) throws HibernateException;
    public Copy getCopiesByMovieType(Movie movie, CopyType copyType)throws HibernateException;
    public void addCopy(Copy copy) throws HibernateException;
}