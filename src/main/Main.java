package main;

import org.hibernate.HibernateException;

import DAO.Factory;
import Logic.Client;

public class Main {

    public static void main(String[] args) {
        try {
            Client client = Factory.getInstance().getClientDAO().getClientById(1);
            System.out.print(client.getName());

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

}