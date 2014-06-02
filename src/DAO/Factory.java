package DAO;

import DAO.Impl.*;

public class Factory {
    private static ClientDAO clientDAO = null;
    private static CompanyDAO companyDAO = null;
    private static CopyDAO copyDAO = null;
    private static DirectorDAO directorDAO = null;
    private static MovieDAO movieDAO = null;
    private static OrderHistoryDAO orderHistoryDAO = null;
    private static CopyTypeDAO copyTypeDAO = null;
    
    private static Factory instance = null;
    
    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }
    
    public ClientDAO getClientDAO() {
        if (clientDAO == null) {
            clientDAO = new ClientDAOImpl();
        }
        return clientDAO;
    }
    
    public CompanyDAO getCompanyDAO() {
        if (companyDAO == null) {
            companyDAO = new CompanyDAOImpl();
        }
        return companyDAO;
    }
    
    public CopyDAO getCopyDAO() {
        if (copyDAO == null) {
            copyDAO = new CopyDAOImpl();
        }
        return copyDAO;
    }

    public DirectorDAO getDirectorDAO() {
        if (directorDAO == null) {
            directorDAO = new DirectorDAOImpl();
        }
        return directorDAO;
    }
    
    public MovieDAO getMovieDAO() {
        if (movieDAO == null) {
            movieDAO = new MovieDAOImpl();
        }
        return movieDAO;
    }
    
    public OrderHistoryDAO getOrderHistoryDAO() {
        if (orderHistoryDAO == null) {
            orderHistoryDAO = new OrderHistoryDAOImpl();
        }
        return orderHistoryDAO;
    }
    public CopyTypeDAO getCopyTypeDAO() {
        if (copyTypeDAO == null) {
            copyTypeDAO = new CopyTypeDAOImpl();
        }
        return copyTypeDAO;
    }
    
}