package DAO;

import Logic.Movie;
import Logic.Company;

import java.util.List;

import org.hibernate.HibernateException;

public interface CompanyDAO {
    public int addCompany(Company company) throws HibernateException;
    public void removeCompany(Company company) throws HibernateException;
    public void updateCompany(Company company) throws HibernateException;
    public Company getCompanyById(int id) throws HibernateException;
    public List<Company> getAllCompanies() throws HibernateException;
}