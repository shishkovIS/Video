package web;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import DAO.Factory;
import Logic.Client;
import Logic.Company;
import Logic.Director;
import Logic.Movie;

@Controller
public class CompaniesController
{  
    
    public static String isoToUtf(String str) {
        try {
            return new String(str.getBytes("iso-8859-1"), "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }
    
    @RequestMapping("/companies")
    public String displayCompanies(ModelMap model)
    {
        List<Company> companies = Factory.getInstance().getCompanyDAO().getAllCompanies();
        model.addAttribute("companies",companies);
        return "companies";
    }
    @RequestMapping("/company")
    public String displayCompany(
            @RequestParam(value="id", required=true) String id,
            ModelMap model)
    {
        Company company = null;
        try 
        {
            company = Factory.getInstance().getCompanyDAO().getCompanyById(Integer.parseInt(id));
        }  catch (Exception e)
           {
               return "redirect:companies";
           }
        model.addAttribute("company",company);
        return "company";
    }
    
    @RequestMapping("/editcompany")
    public String editCompany(
            @RequestParam(value="id", required=true) String id,
            ModelMap model)
    {
        Company company = null;
        try 
        {
            company = Factory.getInstance().getCompanyDAO().getCompanyById(Integer.parseInt(id));
        }  catch (Exception e)
           {
               return "redirect:companies";
           }
        model.addAttribute("company",company);
        return "editcompany";
    }
    
    
    @RequestMapping("/addcompany")
    public String addCompany(ModelMap model)
    {
        return "editcompany";
    }
    @RequestMapping("/savecompany")
    public String saveCompany(
            @RequestParam(value="id", required=false) String id,
            @RequestParam(value="companyName", required=true) String companyName,

            ModelMap model)
    {
            
        companyName = isoToUtf(companyName);
        Company company;
            if (id.isEmpty())
            {
                try
                {
                    company = new Company();
                    company.setCompanyName(companyName);
                    company.setIsRemoved(false);
                    Factory.getInstance().getCompanyDAO().addCompany(company);
                    
                } catch (Exception e)
                {
                    return "redirect:companies";
                }
                return "redirect:companies";
                }
                    else
                    {
                    try 
                    {
                        
                        company = Factory.getInstance().getCompanyDAO().getCompanyById(Integer.parseInt(id));
                        company.setCompanyName(companyName);
                         Factory.getInstance().getCompanyDAO().updateCompany(company);
                         company = Factory.getInstance().getCompanyDAO().getCompanyById(Integer.parseInt(id));
                    }  catch (Exception e)
                        {
                   
                             return "redirect:companies";
                      }
                     model.addAttribute("company",company);
                     return "company";
                   }
            }
    }
    
    
   