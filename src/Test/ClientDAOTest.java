package Test;

import Logic.Client;
import Logic.Movie;
import DAO.Factory;

import java.util.List;

import org.hibernate.HibernateException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = {"DAOTest", "ClientDAOTest"})

public class ClientDAOTest
{
   @Test(groups = {"BeforeEdit"})
    public void getClientByIdTest() {
        Client client = Factory.getInstance().getClientDAO().getClientById(1);
        assert(client != null);
        assert(client.getId() == 1);
        assert(client.getName().equals("Смелянский Руслан Леонидович"));
    //    assert(client.getEmail().equals("smel@gmail.com"));
     }
    @Test(groups = {"BeforeEdit"})
    public void getAllClientsTest() {
        List<Client> clients = Factory.getInstance().getClientDAO().getAllClients();
        assert(clients != null);
        assert(clients.size() == 7);
     }
    
    @Test(groups = {"BeforeEdit"})
    public void getClientsByFilterNameTest() {
        List<Client> clients = Factory.getInstance().getClientDAO().getClientsByFilter("ков",null);
        assert(clients != null);
        assert(clients.size() == 3);
     }
    @Test(dependsOnGroups = {"BeforeEdit"})
    public void addClientTest() {
        Client client = new Client();
        client.setName("Теплова Светлана Евгеньевна");
        client.setAdress("Фадеева 34\7");
        client.setEmail("rottenzombieflesh@gmail.com");
        Factory.getInstance().getClientDAO().addClient(client);
        List<Client> clients = Factory.getInstance().getClientDAO().getAllClients();
        assert(clients != null);
        assert(clients.size() == 8);
      }
   
    @Test(dependsOnGroups = {"BeforeEdit"})
    public void updateClientTest() {
        Client client = Factory.getInstance().getClientDAO().getClientById(1);
        client.setEmail("Smelya@gmail.com");
        Factory.getInstance().getClientDAO().updateClient(client);
        client = Factory.getInstance().getClientDAO().getClientById(1);
        assert(client.getEmail().equals("Smelya@gmail.com"));
    }
    
    
    @Test(dependsOnGroups = {"BeforeEdit"})
    public void removeClientTest() {
        Client client = Factory.getInstance().getClientDAO().getClientById(4);
        Factory.getInstance().getClientDAO().removeClient(client);
        client = Factory.getInstance().getClientDAO().getClientById(4);
        assert(client != null);
        assert(client.getIsRemoved());
    }
    @Test(groups = {"BeforeEdit"})
    public void getClientsByFilterTest() {
        Movie movie = Factory.getInstance().getMovieDAO().getMovieById(6);
        List<Client> clients = Factory.getInstance().getClientDAO().getClientsByFilter(null,movie);
        assert(clients != null);
        assert(clients.size() == 1);
     }
    
}