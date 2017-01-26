package FinalProject;

import java.util.Date;
import java.util.UUID;

/**
 * Created by ExAngelO on 25.01.2017.
 */
public class Order {
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
}
