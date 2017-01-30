package FinalProject.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by ExAngelO on 25.01.2017.
 */
public class Order implements Serializable{
    private UUID id;
    private UUID userID;
    private UUID hotelID;
    private UUID roomID;
    private Date startDate;
    private int days;

    public Order(UUID userID, UUID hotelID, UUID roomID, Date startDate, int days) {
        this.id = UUID.randomUUID();
        this.userID = userID;
        this.hotelID = hotelID;
        this.roomID = roomID;
        this.startDate = startDate;
        this.days = days;
    }

    public UUID getUserID() {
        return userID;
    }

    public UUID getHotelID() {
        return hotelID;
    }

    public UUID getRoomID() {
        return roomID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public int getDays() {
        return days;
    }

    public UUID getOrderID() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(userID, order.userID) &&
                Objects.equals(hotelID, order.hotelID) &&
                Objects.equals(roomID, order.roomID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, hotelID, roomID);
    }
}
