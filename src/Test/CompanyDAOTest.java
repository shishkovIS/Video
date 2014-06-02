package Test;


import Logic.Company;
import DAO.Factory;

import java.util.List;

import org.hibernate.HibernateException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = {"DAOTest", "CompanyDAOTest"})

public class CompanyDAOTest
{
    @Test(groups = {"BeforeEdit"})
    public void getCompanyByIdTest() {
        Company company = Factory.getInstance().getCompanyDAO().getCompanyById(1);
        assert(company != null);
        assert(company.getId() == 1);
        assert(company.getCompanyName().equals("Pixar"));
  
     }
    @Test(groups = {"BeforeEdit"})
    public void getAllCompaniesTest() {
        List<Company> company = Factory.getInstance().getCompanyDAO().getAllCompanies();
        assert(company != null);
        assert(company.size() == 7);
     }
    
  
    
  @Test(dependsOnGroups = {"BeforeEdit"})
    public void addClientTest() {
        Company company = new Company();
        company.setCompanyName("Updated by test Company");
        Factory.getInstance().getCompanyDAO().addCompany(company);
        List<Company> companies = Factory.getInstance().getCompanyDAO().getAllCompanies();
        assert(companies != null);
        assert(companies.size() == 8);
      }
 
    @Test(dependsOnGroups = {"BeforeEdit"})
    public void updateCompanyTest() {
        Company company = Factory.getInstance().getCompanyDAO().getCompanyById(2);
        company.setCompanyName("New Great Company");
        Factory.getInstance().getCompanyDAO().updateCompany(company);
        company = Factory.getInstance().getCompanyDAO().getCompanyById(2);
        assert(company != null);
        assert(company.getId() == 2);
        assert(company.getCompanyName().equals("New Great Company"));
    }
    
    
    @Test(dependsOnGroups = {"BeforeEdit"})
    public void removeCompanyTest() {
        Company company = Factory.getInstance().getCompanyDAO().getCompanyById(4);
        Factory.getInstance().getCompanyDAO().removeCompany(company);
        company = Factory.getInstance().getCompanyDAO().getCompanyById(4);
        assert(company != null);
        assert(company.getIsRemoved());
    }
     
}