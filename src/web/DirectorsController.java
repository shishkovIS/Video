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
public class DirectorsController
{  
    
    public static String isoToUtf(String str) {
        try {
            return new String(str.getBytes("iso-8859-1"), "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }
    
    @RequestMapping("/directors")
    public String displayDirectors(ModelMap model)
    {
        List<Director> directors = Factory.getInstance().getDirectorDAO().getAllDirectors();
        model.addAttribute("directors",directors);
        return "directors";
    }
    @RequestMapping("/director")
    public String displayMovie(
            @RequestParam(value="id", required=true) String id,
            ModelMap model)
    {
        Director director = null;
        try 
        {
            director = Factory.getInstance().getDirectorDAO().getDirectorById(Integer.parseInt(id));
        }  catch (Exception e)
           {
               return "redirect:directors";
           }
        model.addAttribute("director",director);
        return "director";
    }
    
    @RequestMapping("/editdirector")
    public String editMovie(
            @RequestParam(value="id", required=true) String id,
            ModelMap model)
    {
        Director director = null;
        try 
        {
            director = Factory.getInstance().getDirectorDAO().getDirectorById(Integer.parseInt(id));
        }  catch (Exception e)
           {
               return "redirect:directors";
           }
        model.addAttribute("director",director);
        return "editdirector";
    }
    
    
    @RequestMapping("/adddirector")
    public String addDirector(ModelMap model)
    {
        return "editdirector";
    }
    @RequestMapping("/savedirector")
    public String saveDirector(
            @RequestParam(value="id", required=false) String id,
            @RequestParam(value="directorName", required=true) String directorName,

            ModelMap model)
    {
            
            directorName = isoToUtf(directorName);
            Director director;
            if (id.isEmpty())
            {
                try
                {
                    director = new Director();
                    director.setDirectorName(directorName);
                    director.setIsRemoved(false);
                    Factory.getInstance().getDirectorDAO().addDirector(director);
                    
                } catch (Exception e)
                {
                    return "redirect:directors";
                }
                return "redirect:directors";
                }
                    else
                    {
                    try 
                    {
                        
                        director = Factory.getInstance().getDirectorDAO().getDirectorById(Integer.parseInt(id));
                        director.setDirectorName(directorName);
                         Factory.getInstance().getDirectorDAO().updateDirector(director);
                         director = Factory.getInstance().getDirectorDAO().getDirectorById(Integer.parseInt(id));
                    }  catch (Exception e)
                        {
                   
                             return "redirect:directors";
                      }
                     model.addAttribute("director",director);
                     return "director";
                   }
            }
    }
    
    
   