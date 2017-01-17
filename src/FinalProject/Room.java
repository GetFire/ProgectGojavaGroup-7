package FinalProject;
/**
 * Created by GetFire on 15.01.2017 for ProgectGojavaGroup-7.
 */

import java.time.LocalDate;
import java.util.UUID;

/*
@param persons отображает количество спальных мест в номере
@param price отображает стоимость номера за ночь
@param dateAvaiableFrom отображает с какого числа номер свободен
@param hotelName отображает название Отеля
@param isAvaible отображает занят ли номер, по умолчанию true, меняем на false когда юзер его заказал
*/

public class Room {
    private UUID id;
    private int persons;
    private int price;
    private boolean isAvaible = true;
    private LocalDate dateAvaiableFrom;
    private String hotelName;


    public Room(int persons, int price, LocalDate dateAvaiableFrom, String hotelName) {
        this.persons = persons;
        this.price = price;
        this.dateAvaiableFrom = dateAvaiableFrom;
        this.hotelName = hotelName;
        this.id = UUID.randomUUID();
    }


    public Room(int persons, String hotelName, int price) {
        this.price = price;
        this.persons = persons;
        this.hotelName = hotelName;
        this.dateAvaiableFrom = LocalDate.of(2017, 1, 1);
        this.hotelName = hotelName;
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "{ Hotel name: " + hotelName
                + ", persons: " + persons
                + ", price: " + price + "$}";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (persons != room.persons) return false;
        if (price != room.price) return false;
        return hotelName != null ? hotelName.equals(room.hotelName) : room.hotelName == null;

    }

    @Override
    public int hashCode() {
        int result = persons;
        result = 31 * result + price;
        result = 31 * result + (hotelName != null ? hotelName.hashCode() : 0);
        return result;
    }

    public int getPersons() {
        return persons;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getDateAvaiableFrom() {
        return dateAvaiableFrom;
    }

    public String getHotelName() {
        return hotelName;
    }

    public boolean getIsAvaible() {
        return isAvaible;
    }

    public void setAvaible(boolean avaible) {
        isAvaible = avaible;
    }

    public UUID getId() {
        return id;
    }

    public void setDateAvaiableFrom(LocalDate dateAvaiableFrom) {
        this.dateAvaiableFrom = dateAvaiableFrom;
    }
}
