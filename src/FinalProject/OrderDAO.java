package FinalProject;

import java.util.List;

/**
 * Created by tvv89 on 25.01.2017 for FinalProjectGroup7.
 */
public class OrderDAO extends DAOImpl<Order>
{
    private List<Order> orders;

    public OrderDAO(List<Order> orders) {
        this.orders = orders;
    }
    public OrderDAO(){}

    @Override
    public Order save(Order order) {
        orders.add(order);
        return order;
    }

    @Override
    public Order remove(Order order) {
        orders.remove(order);
        return order;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
