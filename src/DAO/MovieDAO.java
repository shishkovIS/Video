package DAO;

import Logic.Company;
import Logic.Director;
import Logic.Movie;
import Logic.Client;

import java.util.List;

import org.hibernate.HibernateException;

public interface MovieDAO {
	public int addMovie(Movie movie) throws HibernateException;
	public void removeMovie(Movie movie) throws HibernateException;
	public void updateMovie(Movie movie) throws HibernateException;
	public Movie getMovieById(int id) throws HibernateException;
	public List<Movie> getMoviesByFilter(String name, Client client,Director director, Company company, int year) throws HibernateException;
	public List<Movie> getAllMovies() throws HibernateException;
}