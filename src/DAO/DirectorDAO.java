package DAO;

import Logic.Movie;
import Logic.Director;
import java.util.List;

import org.hibernate.HibernateException;

public interface DirectorDAO {
	public int addDirector(Director director) throws HibernateException;
	public void removeDirector(Director director) throws HibernateException;
	public void updateDirector(Director director) throws HibernateException;
	public Director getDirectorById(int id) throws HibernateException;
	
	public List<Director> getAllDirectors() throws HibernateException;
}