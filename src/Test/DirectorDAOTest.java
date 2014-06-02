package Test;


import Logic.Company;
import Logic.Director;
import DAO.Factory;

import java.util.List;

import org.hibernate.HibernateException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = {"DAOTest", "DirectorDAOTest"})

public class DirectorDAOTest
{
    @Test(groups = {"BeforeEdit"})
    public void getDirectorByIdTest() {
        Director director = Factory.getInstance().getDirectorDAO().getDirectorById(1);
        assert(director != null);
        assert(director.getId() == 1);
        assert(director.getDirectorName().equals("Том МакГрат"));
  
     }
    @Test(groups = {"BeforeEdit"})
    public void getAllDirectorsTest() {
        List<Director> directors = Factory.getInstance().getDirectorDAO().getAllDirectors();
        assert(directors != null);
        assert(directors.size() == 11);
     }
    
  
    
 @Test(dependsOnGroups = {"BeforeEdit"})
    public void addDirectorTest() {
        Director director = new Director();
        director.setDirectorName("Test Director");
        Factory.getInstance().getDirectorDAO().addDirector(director);
        List<Director> directors = Factory.getInstance().getDirectorDAO().getAllDirectors();
        assert(directors != null);
        assert(directors.size() == 12);
      }
  
    @Test(dependsOnGroups = {"BeforeEdit"})
    public void updateDirectorTest() {
       Director director = Factory.getInstance().getDirectorDAO().getDirectorById(2);
       director.setDirectorName("Updated Director");
        Factory.getInstance().getDirectorDAO().updateDirector(director);
        director = Factory.getInstance().getDirectorDAO().getDirectorById(2);
        assert(director != null);
        assert(director.getId() == 2);
        assert(director.getDirectorName().equals("Updated Director"));
    }
    
    
    @Test(dependsOnGroups = {"BeforeEdit"})
    public void removeDirectorTest() {
        Director director = Factory.getInstance().getDirectorDAO().getDirectorById(4);
        Factory.getInstance().getDirectorDAO().removeDirector(director);
        director = Factory.getInstance().getDirectorDAO().getDirectorById(4);
        assert(director != null);
        assert(director.getIsRemoved());
    }
    
  
}