package FinalProject;

import com.sun.org.apache.xpath.internal.operations.Or;

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

    @Override
    public Order save(Order object) {
        return super.save(object);
    }

    @Override
    public Order remove(Order object) {
        return super.remove(object);
    }


}
