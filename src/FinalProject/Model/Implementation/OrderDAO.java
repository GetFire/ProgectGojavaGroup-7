package FinalProject.Model.Implementation;

import FinalProject.Model.DAOImpl;
import FinalProject.Entity.Order;

import java.util.List;

/**
 * Created by tvv89 on 25.01.2017 for FinalProjectGroup7.
 */
public class OrderDAO extends DAOImpl<Order>
{
    public OrderDAO() {
        super();
    }

    public OrderDAO(List<Order> orders){
        super.setDataBaseList(orders);
    }
    /*
        @Override
        public Order save(Order object) {
            return super.save(object);
        }

        @Override
        public Order remove(Order object) {
            return super.remove(object);
        }

        @Override
        public Order update(Order object) {
            return super.update(object);
        }

    */
    public List<Order> getOrders() {
        return super.getDataBaseList();
    }




}
