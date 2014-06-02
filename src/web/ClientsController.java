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

@Controller
public class ClientsController
{
    public static String isoToUtf(String str) {
        try {
            return new String(str.getBytes("iso-8859-1"), "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }
    
    @RequestMapping("/")
    public String welcomePage(ModelMap model)
    {
        return "redirect:clients";
    }

    
    @RequestMapping("/addclient")
    public String addClient(ModelMap model)
    {
        return "addclient";
    }
    @RequestMapping("/clients")
    public String displayClients(ModelMap model)
    {
        List<Client> clients = Factory.getInstance().getClientDAO().getAllClients();
        model.addAttribute("allclients",clients);
        return "clients";
    }
    
    @RequestMapping("/client")
    public String displayClient(
            @RequestParam(value="id", required=true) String id,
            ModelMap model)
    {
        Client client = null;
        try 
        {
            client = Factory.getInstance().getClientDAO().getClientById(Integer.parseInt(id));
        }  catch (Exception e)
           {
               return "redirect:clients";
           }
        model.addAttribute("client",client);
        return "client";
    }
    @RequestMapping("/editclient")
    public String editClient(
            @RequestParam(value="id", required=true) String id,
            ModelMap model)
    {
        Client client = null;
        try 
        {
            client = Factory.getInstance().getClientDAO().getClientById(Integer.parseInt(id));
        }  catch (Exception e)
           {
               return "redirect:clients";
           }
        model.addAttribute("client",client);
        return "editclient";
    }
    
    @RequestMapping("/deleteclient")
    public String deleteClient(
            @RequestParam(value="id", required=true) String id,
            ModelMap model)
    {
        Client client = null;
        try 
        {
            client = Factory.getInstance().getClientDAO().getClientById(Integer.parseInt(id));
            Factory.getInstance().getClientDAO().removeClient(client);
        }  catch (Exception e)
           {
               return "redirect:clients";
           }
       // model.addAttribute("client",client);
        return "redirect:clients";
    }
    
    
    
    @RequestMapping("/saveclient")
    public String saveClient(
            @RequestParam(value="id", required=false) String id,
            @RequestParam(value="email", required=true) String email,
            @RequestParam(value="adress", required=true) String adress,
            @RequestParam(value="name", required=true) String name,
            ModelMap model)
    {
        email = isoToUtf(email);
        adress = isoToUtf(adress);
        name = isoToUtf(name);
        Client client;
        if (id.isEmpty())
        {
            try
            {
                Client newclient = new Client();
                newclient.setAdress(adress);
                newclient.setName(name);
                newclient.setEmail(email);
                newclient.setIsRemoved(false);
                Factory.getInstance().getClientDAO().addClient(newclient);
                
            } catch (Exception e)
            {
                return "redirect:clients";
            }
            return "redirect:clients";
            }
                else
                {
                try 
                {
                    client = null;
                    client = Factory.getInstance().getClientDAO().getClientById(Integer.parseInt(id));
                    client.setAdress(adress);
                    client.setName(name);
                    client.setEmail(email);
                     Factory.getInstance().getClientDAO().updateClient(client);
                     client = Factory.getInstance().getClientDAO().getClientById(Integer.parseInt(id));
                }  catch (Exception e)
                    {
               
                         return "redirect:clients";
                  }
                 model.addAttribute("client",client);
                 return "client";
               }
        }
}