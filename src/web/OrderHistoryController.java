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
import Logic.Movie;
import Logic.OrderHistory;

@Controller
public class OrderHistoryController
{  
    @RequestMapping("/orderhistory")
    public String showOrderHistory(
            @RequestParam(value="clientid", required=false) String clientid,
            @RequestParam(value="opened", required=false) String opened,
            @RequestParam(value="movieid", required=false) String movieid,
            
            ModelMap model)
    {
        Client client = null;
        Movie movie = null;
        int open = 2;
        if (clientid!=null)
        {
            try
            {
                 client = Factory.getInstance().getClientDAO().getClientById(Integer.parseInt(clientid));
             
            } catch (Exception e)
            {
                return "orderhistory";
            }
        }
        
        if (movieid!=null)
        {
            try
            {
                 movie = Factory.getInstance().getMovieDAO().getMovieById(Integer.parseInt(movieid));
             
            } catch (Exception e)
            {
                return "orderhistory";
            }
        }
        
        if (opened!=null)
        {
            if (opened.equals("1")) open = 1;
            if (opened.equals("0")) open = 0;
            
        }
        List<OrderHistory> orderHistory = Factory.getInstance().getOrderHistoryDAO().getOrderHistoryByFilter(client, null, null, movie,open);
        model.addAttribute("orderitems", orderHistory);
        return "orderhistory";
    }
}