package DAO;

import Logic.OrderHistory;
import Logic.Movie;
import Logic.Client;
import java.util.List;
import java.util.Date;
import org.hibernate.HibernateException;

public interface OrderHistoryDAO {
    public int addOrderHistory(OrderHistory orderHistory) throws HibernateException;
    public void removeOrderHistory(OrderHistory orderHistory) throws HibernateException;
    public void updateOrderHistory(OrderHistory orderHistory) throws HibernateException;
    public OrderHistory getOrderHistoryById(int id) throws HibernateException;
    public List<OrderHistory> getOrderHistoryByFilter (
            Client client,
            Date beginDate,
            Date endDate,
            Movie movie,int opened
            ) throws HibernateException;
    public List<OrderHistory> getAllOrderHistory() throws HibernateException;
}