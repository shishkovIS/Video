package DAO;

import Logic.Copy;
import Logic.CopyType;
import Logic.Movie;
import Logic.Director;

import java.util.List;

import org.hibernate.HibernateException;

public interface CopyTypeDAO {
     public List<CopyType> getAllCopyTypes() throws HibernateException;
     public CopyType getCopyTypeById(int id) throws HibernateException;
}