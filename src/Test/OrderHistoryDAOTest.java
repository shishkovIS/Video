package Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DAO.Factory;
import Logic.Client;
import Logic.Copy;
import Logic.Movie;
import Logic.OrderHistory;

@Test(groups = {"DAOTest", "OrderHistoryDAOTest"})

public class OrderHistoryDAOTest
{
    @Test(groups = {"BeforeEdit"})
    public void getOrderHistoryByIdTest()  {
        OrderHistory orderHistory = Factory.getInstance().getOrderHistoryDAO().getOrderHistoryById(1);
        Client client = Factory.getInstance().getClientDAO().getClientById(1);
         
        assert(orderHistory != null);
        assert(orderHistory.getId() == 1); 
      //  assert(orderHistory.getClient().getName().equals("Смелянский Руслан Леонидович"));
    }
    
    @Test(groups = {"BeforeEdit"})
    public void getOrderHistoryClientTest() {
        Client client = Factory.getInstance().getClientDAO().getClientById(2);
        List<OrderHistory> orderHistory = Factory.getInstance().getOrderHistoryDAO().getOrderHistoryByFilter(client, null, null, null,2);       
        assert(orderHistory != null);
        assert(orderHistory.size() == 1); 
        
    }
   
    
    @Test(groups = {"BeforeEdit"})
    public void getAllOrderHistoryTest() {
        List<OrderHistory> orderHistory = Factory.getInstance().getOrderHistoryDAO().getAllOrderHistory();       
        assert(orderHistory != null);
        assert(orderHistory.size() == 6); 
    }
    
    @Test(groups = {"BeforeEdit"})
    public void getOrderHistoryMovieTest() {
        Movie movie = Factory.getInstance().getMovieDAO().getMovieById(4);
        List<OrderHistory> orderHistory = Factory.getInstance().getOrderHistoryDAO().getOrderHistoryByFilter(null,null,null,movie,2);       
        assert(orderHistory != null);
        assert(orderHistory.size() == 1); 
    }
    
    
    @Test(dependsOnGroups = {"BeforeEdit"})
      public void addOrderHistoryTest() {
          OrderHistory orderHistory = new OrderHistory();
          Client client = Factory.getInstance().getClientDAO().getClientById(1);
          Copy copy = Factory.getInstance().getCopyDAO().getCopyById(1);
          Movie movie = Factory.getInstance().getMovieDAO().getMovieById(1);
          orderHistory.setClient(client);
          orderHistory.setCopy(copy);
          orderHistory.setPayout(23);
          orderHistory.setReturned(false);
          orderHistory.setMovie(movie);
          java.util.Date utilDate = new java.util.Date();
          java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
          orderHistory.setOrderTime(sqlDate);
         // orderHistory.setReturnTime(java.sql.Date.valueOf("2014-02-13 13:00:00"));
          Factory.getInstance().getOrderHistoryDAO().addOrderHistory(orderHistory);
          List<OrderHistory> orderHist = Factory.getInstance().getOrderHistoryDAO().getAllOrderHistory();
          assert(orderHist != null);
          assert(orderHist.size() == 7);
        }
  
      @Test(dependsOnGroups = {"BeforeEdit"})
      public void updateOrderHistoryTest() {
          OrderHistory orderHistory = Factory.getInstance().getOrderHistoryDAO().getOrderHistoryById(2);
          orderHistory.setPayout(333);
          Factory.getInstance().getOrderHistoryDAO().updateOrderHistory(orderHistory);
          orderHistory = Factory.getInstance().getOrderHistoryDAO().getOrderHistoryById(2);
          assert(orderHistory != null);
          assert(orderHistory.getId() == 2);
          assert(orderHistory.getPayout()== 333);
      }
      
      
      @Test(dependsOnGroups = {"BeforeEdit"})
      public void removeOrderHisoryTest() {
          OrderHistory orderHistory = Factory.getInstance().getOrderHistoryDAO().getOrderHistoryById(4);
          Factory.getInstance().getOrderHistoryDAO().removeOrderHistory(orderHistory);
          orderHistory = Factory.getInstance().getOrderHistoryDAO().getOrderHistoryById(4);
          assert(orderHistory != null);
          assert(orderHistory.getIsRemoved());
      }
      
}