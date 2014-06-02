package Test;

import Logic.Client;
import Logic.Company;
import Logic.Director;
import Logic.Movie;
import DAO.Factory;

import java.util.List;

import org.hibernate.HibernateException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = {"DAOTest", "MovieDAOTest"})

public class MovieDAOTest
{
   @Test(groups = {"BeforeEdit"})
    public void getMovieByIdTest() {
        Movie movie = Factory.getInstance().getMovieDAO().getMovieById(1);
        assert(movie != null);
        assert(movie.getId() == 1);
        assert(movie.getTitle().equals("Мадагаскар"));
    }
   
   
   
 @Test(dependsOnGroups = {"BeforeEdit"})
    public void addMovieTest() {
        Movie movie = new Movie();
        movie.setTitle("The best film I have ever seen");
        Director director = Factory.getInstance().getDirectorDAO().getDirectorById(1);
        Company company = Factory.getInstance().getCompanyDAO().getCompanyById(1);
        movie.setDirector(director);
        movie.setCompany(company);
        movie.setIsRemoved(false);
        movie.setYear(1996);
        Factory.getInstance().getMovieDAO().addMovie(movie);
        
        List<Movie> movies = Factory.getInstance().getMovieDAO().getAllMovies();
        assert(movies != null);
        assert(movies.size() == 13);
      }
  
    @Test(dependsOnGroups = {"BeforeEdit"})
    public void updateMovieTest() {
       Movie movie = Factory.getInstance().getMovieDAO().getMovieById(2);
       movie.setTitle("Updated Movie");
        Factory.getInstance().getMovieDAO().updateMovie(movie);
        movie = Factory.getInstance().getMovieDAO().getMovieById(2);
        assert(movie != null);
        assert(movie.getId() == 2);
        assert(movie.getTitle().equals("Updated Movie"));
    }
    
    
    @Test(dependsOnGroups = {"BeforeEdit"})
    public void removeMovieTest() {
        Movie movie = Factory.getInstance().getMovieDAO().getMovieById(4);
        Factory.getInstance().getMovieDAO().removeMovie(movie);
        movie = Factory.getInstance().getMovieDAO().getMovieById(4);
        assert(movie != null);
        assert(movie.getIsRemoved());
    }
    
    
    @Test(groups = {"BeforeEdit"})
    public void getAllMoviesTest() {
        List<Movie> movies = Factory.getInstance().getMovieDAO().getAllMovies();
        assert(movies != null);
        assert(movies.size() == 12);
     }
    
    
    @Test(groups = {"BeforeEdit"})
    public void getMoviesByFilterNameTest() {
        List<Movie> movies = Factory.getInstance().getMovieDAO().getMoviesByFilter("сеть",null,null,null,0);
        assert(movies != null);
        assert(movies.size() == 1);
     }
    
    @Test(groups = {"BeforeEdit"})
    public void getMoviesByFilterClientTest() {
     
            Client client = Factory.getInstance().getClientDAO().getClientById(3);
            List<Movie> movies = Factory.getInstance().getMovieDAO().getMoviesByFilter(null,client,null,null,0);
            assert(movies != null);
            assert(movies.size() == 1);
            assert(movies.get(0).getTitle().equals("Спиоск Шиндлера"));
         }
    
    
    @Test(groups = {"BeforeEdit"})
    public void getMoviesByFilterDirectorTest() {
        Director director = Factory.getInstance().getDirectorDAO().getDirectorById(4);
        List<Movie> movies = Factory.getInstance().getMovieDAO().getMoviesByFilter(null,null,director,null,0);
        assert(movies != null);
        assert(movies.size() == 2);
     }
    
    
    @Test(groups = {"BeforeEdit"})
    public void getMoviesByFilterCompanyTest() {
        Company company = Factory.getInstance().getCompanyDAO().getCompanyById(4);
        List<Movie> movies = Factory.getInstance().getMovieDAO().getMoviesByFilter(null,null,null,company,0);
        assert(movies != null);
        assert(movies.size() == 2);
     }
    @Test(groups = {"BeforeEdit"})
    public void getMoviesByFilterYearTest() {
        List<Movie> movies = Factory.getInstance().getMovieDAO().getMoviesByFilter(null,null,null,null,2009);
        assert(movies != null);
        assert(movies.size() == 3);
     }
}