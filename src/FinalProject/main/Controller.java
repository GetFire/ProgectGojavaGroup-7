package FinalProject.main;

/**
 * Created by GetFire on 15.01.2017 for ProgectGojavaGroup-7.
 * <p>
 * An instance of this class simulates user operation
 */

import java.util.*;
import java.util.stream.Collectors;


import static FinalProject.main.Hotel.*;


public class Controller {

    private UserDAO userService;
    private OrderDAO orderService;
    private HotelDAO hotelService;


    public Controller(List<Hotel> hotels, Set<User> users, List<Order> orders) {
        this.hotelService = new HotelDAO(hotels);
        this.userService = new UserDAO(users);
        this.orderService = new OrderDAO(orders);

    }

    /**
     * Find hotels by name
     */
    public Collection<Hotel> findHotelByName(String name) {
        List<Hotel> hotel = hotelService.getHotels().stream().filter(a -> a.getHotelName().contains(name)).collect(Collectors.toList());
        if (hotel.size() == 0) System.out.println("Not found");
        return hotel;

    }


    /**
     * Find hotels by name city
     */
    public Collection<Hotel> findHotelByCity(String city) {
        List<Hotel> hotel = hotelService.getHotels().stream().filter(a -> a.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
        if (hotel.size() == 0) System.out.println("Not found");
        return hotel;

    }

    /**
     * booked the room
     */
    public void bookRoom(UUID roomID, User user, UUID hotelID, Date startDate, int days) throws InvalidFormException {
        /*
        List<Hotel> foundedHotels = hotels.stream().filter(a -> a.getId().equals(hotelID)).collect(Collectors.toList());
        Hotel hotel = foundedHotels.get(0);
        List<Room> rooms = hotel.getRooms().stream().filter(a -> a.getId().equals(roomID)).collect(Collectors.toList());
        Room foundedRoom = rooms.get(0);
        foundedRoom.setAvaible(false);
        */
        //check: Is the room booked, or not
        if (user.getLogin()) {
            List<Order> filteredOrder = orderService.getOrders().stream().filter(a -> (a.getHotelID().equals(hotelID) && a.getRoomID().equals(roomID))).collect(Collectors.toList());
            for (Order i : filteredOrder) {
                boolean flag = false;
                Calendar cal = Calendar.getInstance();
                cal.setTime(startDate);
                cal.set(Calendar.DAY_OF_MONTH, days);
                long firstDay = i.getStartDate().getTime();
                long lastDay = cal.getTime().getTime();
                for (int j = 0; j < days; j++) {
                    Calendar caltmp = Calendar.getInstance();
                    caltmp.setTime(startDate);
                    caltmp.set(Calendar.DAY_OF_MONTH, j);
                    long currentDay = caltmp.getTime().getTime();
                    if (firstDay < currentDay && currentDay < lastDay) {
                        throw new InvalidFormException("This dates are reserved");
                    }
                }
            }
            //add order
            orderService.save(new Order(user.getId(), hotelID, roomID, startDate, days));
        } else
            System.out.println("If you want to book the room, you must be logIn!");
    }


    public void cancelReservation(UUID roomID, User user, UUID hotelID) throws InvalidFormException {
        //filter order from user, by hotel and room
        if (user.getLogin()) {
            List<Order> filteredOrder = orderService.getOrders().stream().filter(a -> (a.getHotelID().equals(hotelID) && a.getRoomID().equals(roomID) && a.getUserID().equals(user.getId()))).collect(Collectors.toList());
            if (filteredOrder.isEmpty()) throw new InvalidFormException("Order not found, input correct data");
            else {
                //delete all filtered orders
                try {
                    filteredOrder.forEach(orderService::remove);
                } catch (NullPointerException e) {
                    throw new InvalidFormException(e.getMessage() + " where we cancel reservation");
                }

            }

        } else
            System.out.println("If you want to cancel the reservation, you must be logIn!");
    }

    public Collection<Room> findRoom(Map<String, String> params) {
        List<Room> found = new ArrayList<>();
        String city = params.get(CITY);
        String hotelName = params.get(HOTEL_NAME);
        int price;
        int persons;

        try {
            price = Integer.parseInt(params.get(PRICE));
        } catch (Exception e) {
            price = 0;
        }
        try {
            persons = Integer.parseInt(params.get(PERSONS));
        } catch (Exception ex) {
            persons = 0;
        }


// Set variable of searching

        int flag = 0;
        if (price != 0 && persons != 0) flag = 1;
        else if (price == 0 && persons != 0) flag = 2;
        else if (price != 0 && persons == 0) flag = 3;
        else if (price == 0 && persons == 0) flag = 4;

        switch (flag) {
            case 1:
                Optional<Hotel> first = hotelService.getHotels().stream()
                        .filter(a -> a.getCity().equals(city))
                        .filter(a -> a.getHotelName().contains(hotelName))
                        .findFirst();
                if (first.isPresent()) {
                    List<Room> found1 = first.get().getRooms();
                    for (int i = 0; i < found1.size(); i++) {
                        if (found1.get(i).getPrice() <= price && found1.get(i).getPersons() >= persons) {
                            continue;
                        }
                        found1.remove(i);
                        i--;
                    }
                    found = found1;
                } else {
                    System.out.println("Not found. Try to change your parameters");
                }
                break;
            case 2:
                Optional<Hotel> second = hotelService.getHotels().stream()
                        .filter(a -> a.getCity().equals(city))
                        .filter(a -> a.getHotelName().contains(hotelName))
                        .findFirst();
                if (second.isPresent()) {
                    List<Room> found2 = second.get().getRooms();
                    for (int i = 0; i < found2.size(); i++) {
                        if (found2.get(i).getPersons() >= persons) {
                            continue;
                        }
                        found2.remove(i);
                        i--;
                    }
                    found = found2;
                } else {
                    System.out.println("Not found. Try to change your parameters");
                }
                break;

            case 3:
                Optional<Hotel> third = hotelService.getHotels().stream()
                        .filter(a -> a.getCity().equals(city))
                        .filter(a -> a.getHotelName().contains(hotelName))
                        .findFirst();
                if (third.isPresent()) {
                    List<Room> found3 = third.get().getRooms();
                    for (int i = 0; i < found3.size(); i++) {
                        if (found3.get(i).getPrice() <= price) {
                            continue;
                        }
                        found3.remove(i);
                        i--;
                    }
                    found = found3;
                } else {
                    System.out.println("Not found. Try to change your parameters");
                }
                break;
            case 4:
                Optional<Hotel> fouth = hotelService.getHotels().stream()
                        .filter(a -> a.getCity().equals(city))
                        .filter(a -> a.getHotelName().contains(hotelName))
                        .findFirst();
                if (fouth.isPresent()) {
                    found = fouth.get().getRooms();
                } else {
                    System.out.println("Not found. Try to change your parameters");
                }
                break;
        }
        if (found.size() == 0)
            System.out.println("Not found. Try to change your parameters");

        return found;
    }

    public User registerUser(User user) {
        if (!userService.getUsers().contains(user)) {
            userService.save(user);
            System.out.println(user.getNickname() + " добро пожаловать!");
            userService.writeUserDao(userService.getUsers());
            user.setLogin(true);
        } else {
            System.out.println("С возвращением! Мы по тебе скучали!");
            user.setLogin(true);
        }
        return user;
    }


    public Controller(List<Hotel> hotels) {
        this.hotelService = new HotelDAO(hotels);
    }

    public Controller() {
        this.hotelService = new HotelDAO();
        this.userService = new UserDAO();
        this.orderService = new OrderDAO();
    }
}
