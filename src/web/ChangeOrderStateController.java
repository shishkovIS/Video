package web;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import Logic.Copy;
import Logic.CopyType;
import Logic.Movie;
import Logic.OrderHistory;

@Controller
public class ChangeOrderStateController
{
     @RequestMapping("/createorder")
     public String createOrder(ModelMap model)
     {
         List<Client> clients;
         List<Movie> movies;
         List<CopyType> copyTypes;
         try
         {
             clients = Factory.getInstance().getClientDAO().getAllClients();
             movies = Factory.getInstance().getMovieDAO().getAllMovies();
            copyTypes = Factory.getInstance().getCopyTypeDAO().getAllCopyTypes();
         } catch (Exception e)
         {
             return "redirect:orderhistory";
         }
         model.addAttribute("clients", clients);
         model.addAttribute("movies", movies);
         model.addAttribute("copyTypes", copyTypes);
         
         return "createorder";
     }
     
     
     
     @RequestMapping("/editcopycount")
     public String editCopyCount(
             @RequestParam(value="movieid", required=true) String movieid,
             ModelMap model)
     {
        List<Copy> copy;
         try
         {
             copy = Factory.getInstance().getCopyDAO().getCopiesByMovie(Factory.getInstance().getMovieDAO().getMovieById(Integer.parseInt(movieid)));
                          
         } catch (Exception e)
         {
             return "redirect:movies";
         }
         model.addAttribute("copy",copy);
         model.addAttribute("movieid", movieid);
         return "editcopycount";
     }
    
     @RequestMapping("/savecopycount")
     public String saveCopyCount(
             @RequestParam(value="a1", required=false) String a1,
             @RequestParam(value="a2", required=false) String a2,
             @RequestParam(value="a3", required=false) String a3,
             @RequestParam(value="a4", required=false) String a4,
             @RequestParam(value="movieid", required=false) String movieid,
             
             ModelMap model)
     {
         
        List<Copy> copy;
        int first;
        int second;
        int third;
        int fourth;
         try
         {
             if (!a1.isEmpty()&&a1!=null)
             {    
                 first = Integer.parseInt(a1);
                 Movie movie = Factory.getInstance().getMovieDAO().getMovieById(Integer.parseInt(movieid));
                 CopyType copyType = Factory.getInstance().getCopyTypeDAO().getCopyTypeById(1);
                 Copy cope = Factory.getInstance().getCopyDAO().getCopiesByMovieType(movie, copyType);
                 cope.setCount(cope.getCount()+first);
                 cope.setCountAvailable(cope.getCountAvailable()+first);
                 Factory.getInstance().getCopyDAO().updateCopy(cope);
             }
             if (!a2.isEmpty()&&a2!=null)
             { 
                 second = Integer.parseInt(a2);
                 Movie movie = Factory.getInstance().getMovieDAO().getMovieById(Integer.parseInt(movieid));
                 CopyType copyType = Factory.getInstance().getCopyTypeDAO().getCopyTypeById(2);
                 Copy cope = Factory.getInstance().getCopyDAO().getCopiesByMovieType(movie, copyType);
                 cope.setCount(cope.getCount()+second);
                 cope.setCountAvailable(cope.getCountAvailable()+second);
                 Factory.getInstance().getCopyDAO().updateCopy(cope);
                 
             }
             if (!a3.isEmpty()&&a3!=null)
             {
                 third = Integer.parseInt(a3);
                 Movie movie = Factory.getInstance().getMovieDAO().getMovieById(Integer.parseInt(movieid));
                 CopyType copyType = Factory.getInstance().getCopyTypeDAO().getCopyTypeById(3);
                 Copy cope = Factory.getInstance().getCopyDAO().getCopiesByMovieType(movie, copyType);
                 cope.setCount(cope.getCount()+third);
                 cope.setCountAvailable(cope.getCountAvailable()+third);
                 Factory.getInstance().getCopyDAO().updateCopy(cope);
             }
             if (!a4.isEmpty()&&a4!=null)
             {
                 fourth = Integer.parseInt(a4);
                 Movie movie = Factory.getInstance().getMovieDAO().getMovieById(Integer.parseInt(movieid));
                 CopyType copyType = Factory.getInstance().getCopyTypeDAO().getCopyTypeById(4);
                 Copy cope = Factory.getInstance().getCopyDAO().getCopiesByMovieType(movie, copyType);
                 cope.setCount(cope.getCount()+fourth);
                 cope.setCountAvailable(cope.getCountAvailable()+fourth);
                 Factory.getInstance().getCopyDAO().updateCopy(cope);
             }
                
         } catch (Exception e)
         {
             return "redirect:movies";
         }
    
         return "redirect:movies";
     }
     
     
     
     @RequestMapping("/closeorder")
     public String closeOrder(
             @RequestParam(value="orderhistoryid", required=true) String orderhistoryid,
             ModelMap model)
     {
      
         OrderHistory orderHistory;
         try
         {
             orderHistory = Factory.getInstance().getOrderHistoryDAO().getOrderHistoryById(Integer.parseInt(orderhistoryid));
             
         } catch (Exception e)
         {
             return "redirect:orderhistory";
         }
         
         model.addAttribute("orderHistory", orderHistory);
         
         return "closeorder";
     }
     
     
     @RequestMapping("/saveclosedorder")
     public String saveClosedOrder(
             @RequestParam(value="returnTime", required=true) String returnTime,
             @RequestParam(value="orderhistoryid", required=true) String orderhistoryid,
             @RequestParam(value="rentCost", required=true) String rentCost,
             ModelMap model)
     {
         OrderHistory orderHistory;
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         Date parsed;
         try
         {
             orderHistory = Factory.getInstance().getOrderHistoryDAO().getOrderHistoryById(Integer.parseInt(orderhistoryid));
             Copy copy = orderHistory.getCopy();
             copy.setCountAvailable(copy.getCountAvailable()+1);
             Factory.getInstance().getCopyDAO().updateCopy(copy);
             parsed = format.parse(returnTime);
             orderHistory.setReturnTime(parsed);
             orderHistory.setPayout(Integer.parseInt(rentCost));
             Factory.getInstance().getOrderHistoryDAO().updateOrderHistory(orderHistory);
         } catch (Exception e)
         {
             return "redirect:orderhistory";
         }
         
         return "redirect:orderhistory";
     }
                    
     @RequestMapping("/saveorder")
     public String saveOrder(
             @RequestParam(value="movieid", required=true) String movieid,
             @RequestParam(value="clientid", required=true) String clientid,
             @RequestParam(value="copyTypeid", required=true) String copyTypeid,
             @RequestParam(value="orderTime", required=true) String orderTime,
             
             ModelMap model)
     {
     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
     Date parsed;
     Movie movie;
     Client client;
     CopyType copyType;
     Copy copy;
     try
       {
          parsed = format.parse(orderTime);
           movie = Factory.getInstance().getMovieDAO().getMovieById(Integer.parseInt(movieid));
           client = Factory.getInstance().getClientDAO().getClientById(Integer.parseInt(clientid));
           copyType = Factory.getInstance().getCopyTypeDAO().getCopyTypeById(Integer.parseInt(copyTypeid));
           copy = Factory.getInstance().getCopyDAO().getCopiesByMovieType(movie, copyType);
           if (copy.getCountAvailable()==0)
           {
               return "redirect:createorder";
           }
           
           OrderHistory orderHistory = new OrderHistory();  
           orderHistory.setClient(client);
           orderHistory.setCopy(copy);
           orderHistory.setIsRemoved(false);
           orderHistory.setOrderTime(parsed);
           orderHistory.setMovie(movie);
           Factory.getInstance().getOrderHistoryDAO().addOrderHistory(orderHistory);
           copy.setCountAvailable(copy.getCountAvailable()-1);
           Factory.getInstance().getCopyDAO().updateCopy(copy);
       } catch (Exception e)
         {
           return "redirect:createorder";
         }
     
    
     return "redirect:orderhistory";
     }
}