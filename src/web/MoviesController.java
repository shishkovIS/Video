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
import Logic.Copy;
import Logic.CopyType;
import Logic.Director;
import Logic.Movie;

@Controller
public class MoviesController
{  
    
    public static String isoToUtf(String str) {
        try {
            return new String(str.getBytes("iso-8859-1"), "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }
    
    @RequestMapping("/movies")
    public String displayMovies(
            @RequestParam(value="directorid", required=false) String directorid,
            @RequestParam(value="companyid", required=false) String companyid,
            @RequestParam(value="name", required=false) String name,
            @RequestParam(value="year", required=false) String year,
            
            ModelMap model
            )
    {
        Director director = null;
        Company company = null;
        int searchYear = 0;
        String searchName = null;
        List<Movie> movies;
        try
        {
            if (directorid!=null)
            {
                director = Factory.getInstance().getDirectorDAO().getDirectorById(Integer.parseInt(directorid));
            }
            if (companyid != null)
            {
                company = Factory.getInstance().getCompanyDAO().getCompanyById(Integer.parseInt(companyid));
            }
            if (year!=null && year!="")
                searchYear=Integer.parseInt(year);
            if (name!=null)
            {
                searchName = isoToUtf(name);
              //  searchName= name;
            }
            movies = Factory.getInstance().getMovieDAO().getMoviesByFilter(searchName, null, director, company, searchYear);
                 
        } catch(Exception e)
        {
          return "movies";  
        }
        model.addAttribute("movies",movies);
        return "movies";
    }
    @RequestMapping("/movie")
    public String displayMovie(
            @RequestParam(value="id", required=true) String id,
            ModelMap model)
    {
        Movie movie = null;
        List<Copy> copies;
        try 
        {
            movie = Factory.getInstance().getMovieDAO().getMovieById(Integer.parseInt(id));
            copies = Factory.getInstance().getCopyDAO().getCopiesByMovie(movie);
        }  catch (Exception e)
           {
               return "redirect:movies";
           }
        model.addAttribute("copies",copies);
        model.addAttribute("movie",movie);
        return "movie";
    }
    
    @RequestMapping("/editmovie")
    public String editMovie(
            @RequestParam(value="id", required=true) String id,
            ModelMap model)
    {
        Movie movie = null;
        List<Company> companies = null;
        List<Director> directors = null;
        try 
        {
            movie = Factory.getInstance().getMovieDAO().getMovieById(Integer.parseInt(id));
            companies = Factory.getInstance().getCompanyDAO().getAllCompanies();
            directors = Factory.getInstance().getDirectorDAO().getAllDirectors();
        }  catch (Exception e)
           {
               return "redirect:movies";
           }
        model.addAttribute("companies", companies);
        model.addAttribute("directors",directors);
        model.addAttribute("movie",movie);
        return "editmovie";
    }
    
    
    @RequestMapping("/addmovie")
    public String addMovie(ModelMap model)
    {
        List<Company> companies = null;
        List<Director> directors = null;
        try 
        {
            companies = Factory.getInstance().getCompanyDAO().getAllCompanies();
            directors = Factory.getInstance().getDirectorDAO().getAllDirectors();
        }  catch (Exception e)
           {
               return "redirect:movies";
           }
        model.addAttribute("companies", companies);
        model.addAttribute("directors",directors);
        return "editmovie";
    }
    
    @RequestMapping("/deletemovie")
    public String deleteMovie(
            @RequestParam(value="id", required=true) String id,
            ModelMap model)
    {
        Movie movie = null;
        try 
        {
            movie = Factory.getInstance().getMovieDAO().getMovieById(Integer.parseInt(id));
            Factory.getInstance().getMovieDAO().removeMovie(movie);
        }  catch (Exception e)
           {
               return "redirect:movies";
           }
        return "redirect:movies";
    }
    
    
    @RequestMapping("/savemovie")
    public String saveClient(
            @RequestParam(value="id", required=false) String id,
            @RequestParam(value="company", required=true) String company,
            @RequestParam(value="director", required=true) String director,
            @RequestParam(value="year", required=true) String year,
            @RequestParam(value="title", required=true) String title,
            
            ModelMap model)
    {
        title = isoToUtf(title);
        
        Movie movie;
        if (id.isEmpty())
        {
            try
            {
                 movie = new Movie();
                 movie.setCompany(Factory.getInstance().getCompanyDAO().getCompanyById(Integer.parseInt(company)));
                 movie.setDirector(Factory.getInstance().getDirectorDAO().getDirectorById(Integer.parseInt(director)));
                 movie.setYear(Integer.parseInt(year));
                 movie.setTitle(title);
                movie.setIsRemoved(false);
                Factory.getInstance().getMovieDAO().addMovie(movie);
                
                List<CopyType> copyType = Factory.getInstance().getCopyTypeDAO().getAllCopyTypes();
                for (int i=0;i<copyType.size();i++)
                {
                    Copy copy = new Copy();
                    copy.setCopyType(copyType.get(i));
                    copy.setCount(5);
                    copy.setCountAvailable(5);
                    copy.setIsRemoved(false);
                    copy.setMovie(movie);
                    copy.setRentCost(0);
                    Factory.getInstance().getCopyDAO().addCopy(copy);
                }
            } catch (Exception e)
            {
                return "redirect:movies";
            }
            return "redirect:movies";
            }
                else
                {
                try 
                {
                    movie = null;
                    movie = Factory.getInstance().getMovieDAO().getMovieById(Integer.parseInt(id));
                    movie.setCompany(Factory.getInstance().getCompanyDAO().getCompanyById(Integer.parseInt(company)));
                    movie.setDirector(Factory.getInstance().getDirectorDAO().getDirectorById(Integer.parseInt(director)));
                    movie.setYear(Integer.parseInt(year));
                    movie.setTitle(title);
                    Factory.getInstance().getMovieDAO().updateMovie(movie);
                    movie = Factory.getInstance().getMovieDAO().getMovieById(Integer.parseInt(id));
                }  catch (Exception e)
                    {
               
                         return "redirect:movies";
                  }
                 model.addAttribute("movie",movie);
                 return "movie";
               }
        }
    
   }