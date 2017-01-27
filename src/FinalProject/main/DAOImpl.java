package FinalProject.main;

import java.util.Collection;

/**
 * Created by GetFire on 15.01.2017 for ProgectGojavaGroup-7.
 */

public class DAOImpl<T> implements DAO<T> {
    /**UPD 25.01.17:
     * Подсказка для @olexandr. Напиши тут тело методов, а потом наследуй этот класс классами UserDAO, RoomDAO, HotelDAO, OrderDAO*/
    Collection<T> BAS;
    @Override
    public T save(T object) {
        BAS.add(object);
        return object;
    }

    @Override
    public T remove(T object) {
        BAS.remove(object);
        return object;
    }

    @Override
    public T update(T object) {
        return null;
    }
}
