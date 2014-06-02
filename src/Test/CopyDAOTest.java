package Test;

import java.util.List;

import org.hibernate.HibernateException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DAO.Factory;
import Logic.Client;
import Logic.Copy;
import Logic.Movie;

@Test(groups = {"DAOTest", "CopyDAOTest"})

public class CopyDAOTest
{
   
    @Test(groups = {"BeforeEdit"})
    public void getAllCopiesTest() {
        List<Copy> copies = Factory.getInstance().getCopyDAO().getAllCopies();
        assert(copies != null);
        assert(copies.size() == 25);
     }
    
    
    @Test(groups = {"BeforeEdit"})
    public void getCopyByMovieTest() {
        Movie movie = Factory.getInstance().getMovieDAO().getMovieById(6);
        List<Copy> copies = Factory.getInstance().getCopyDAO().getCopiesByMovie(movie);
        int sum = copies.get(0).getCount()+copies.get(1).getCount();
        assert(copies != null);
        assert(copies.size() == 2);
        assert(sum == 10);
    }
    
  
    
    @Test(dependsOnGroups = {"BeforeEdit"})
    public void updateCopyTest() {
        Copy copy = Factory.getInstance().getCopyDAO().getCopyById(2);
        copy.setCount(20);
        copy.setCountAvailable(20);
        Factory.getInstance().getCopyDAO().updateCopy(copy);
        
        copy = Factory.getInstance().getCopyDAO().getCopyById(2);
        
        assert(copy != null);
        assert(copy.getId() == 2);
        assert(copy.getCount() == 20);
        assert(copy.getCountAvailable() == 20);
    }
    
    
  
}