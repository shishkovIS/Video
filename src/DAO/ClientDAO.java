package DAO;

import Logic.Movie;
import Logic.Client;

import java.util.List;

import org.hibernate.HibernateException;

public interface ClientDAO {
	public int addClient(Client client) throws HibernateException;
	public void removeClient(Client client) throws HibernateException;
	public void updateClient(Client client) throws HibernateException;
	public Client getClientById(int id) throws HibernateException;
	public List<Client> getClientsByFilter (
			String name,
			Movie movie
			) throws HibernateException;
	public List<Client> getAllClients() throws HibernateException;
}