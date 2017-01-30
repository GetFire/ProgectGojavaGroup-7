package FinalProject.Controller;

/**
 * Created by GetFire on 15.01.2017 for ProgectGojavaGroup-7.
 * <p>
 * An instance of this class simulates user operation
 */

import FinalProject.Entity.Hotel;
import FinalProject.Entity.Order;
import FinalProject.Entity.Room;
import FinalProject.Entity.User;
import FinalProject.Model.Implementation.HotelDAO;
import FinalProject.Model.Implementation.OrderDAO;
import FinalProject.Model.Implementation.UserDAO;
import FinalProject.Services.*;

import java.util.*;
import java.util.stream.Collectors;


import static FinalProject.Entity.Hotel.*;


public class Controller {

    private static UserDAO userService;
    private static OrderDAO orderService;
    private static HotelDAO hotelService;


    public Controller(List<Hotel> hotels, List<User> users, List<Order> orders) {
        hotelService = new HotelDAO(hotels);
        userService = new UserDAO(users);
        orderService = new OrderDAO(orders);

    }

    /**
     * Find hotels by name
     */
    public Collection<Hotel> findHotelByName(String aName) {
        String name = aName.toUpperCase();
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
        //check: Is the room booked, or not
        if (user.hasLoggedIN()) {
            List<Order> filteredOrder = orderService.getOrders().stream().filter(a -> (a.getHotelID().equals(hotelID) && a.getRoomID().equals(roomID))).collect(Collectors.toList());
            for (Order i : filteredOrder) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(startDate);
                cal.add(Calendar.DAY_OF_MONTH, days);
                long firstDay = i.getStartDate().getTime();
                long lastDay = cal.getTime().getTime();
                for (int j = 0; j < days; j++) {
                    Calendar caltmp = Calendar.getInstance();
                    caltmp.setTime(startDate);
                    caltmp.add(Calendar.DAY_OF_MONTH, j);
                    long currentDay = caltmp.getTime().getTime();
                    if (firstDay <= currentDay && currentDay < lastDay) {
                        throw new InvalidFormException("These dates are already reserved");
                    }
                }
            }
            //add order
            orderService.save(new Order(user.getId(), hotelID, roomID, startDate, days));
            System.out.println("Congratulations! You have booked the room!"+"From " + startDate + " for " + days + " day(s)");
        } else
            System.out.println("Sorry, you should be logged in to continue!");
    }


    public void cancelReservation(UUID roomID, User user, UUID hotelID) throws InvalidFormException {
        //filter order from user, by hotel and room
        if (user.hasLoggedIN()) {

            List<Order> filteredOrder = orderService.getOrders().stream().filter(a -> (a.getHotelID().equals(hotelID) && a.getRoomID().equals(roomID) && a.getUserID().equals(user.getId()))).collect(Collectors.toList());
            if (filteredOrder.isEmpty()) throw new InvalidFormException("Order not found, input correct data");
            else {
                //delete all filtered orders
                try {
                    filteredOrder.forEach(orderService::remove);
                    System.out.println("Your reservation was cancelled!");
                } catch (NullPointerException e) {
                    throw new InvalidFormException(e.getMessage() + " where we cancel reservation");
                }

            }

        } else
            System.out.println("Sorry, you should be logged in to cancel the reservation!");
    }

    public Collection<Room> findRoom(Map<String, String> params) {
        List<Room> found = new ArrayList<>();
        String city = params.get(CITY);
        String aName = params.get(HOTEL_NAME);
        String hotelName = aName.toUpperCase();
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

        Optional<Hotel> first = hotelService.getHotels().stream()
                .filter(a -> a.getCity().equalsIgnoreCase(city))
                .filter(a -> a.getHotelName().contains(hotelName))
                .findFirst();
        if (first.isPresent()) {
            found = first.get().getRooms();
            for (int i = 0; i < found.size(); i++) {
                if (price > 0) {
                    if (found.get(i).getPrice() <= price && found.get(i).getPersons() >= persons) {
                        continue;
                    }
                } else if (found.get(i).getPersons() >= persons) {
                    continue;
                }
                found.remove(i);
                i--;
            }
        } else {
            System.out.println("Not found. Try to change your parameters");
        }
        if (found.size() == 0)
            System.out.println("Not found. Try to change your parameters");
        return found;
    }

    public static User registerUser(User user) {
        if (!userService.getUsers().contains(user)) {
            userService.save(user);
//            System.out.println(user.getNickname() + " добро пожаловать!");
            System.out.println(user.getNickname() + " welcome!");
            userService.writeUserDao(userService.getUsers());
            user.setLogin(true);
        } else {
//            System.out.println("С возвращением! Мы по тебе скучали!");
            System.out.println("Welcome back! We were missing you!");
            user.setLogin(true);
        }
        return user;
    }

    public static User getUserByNickname(String nickname) {
        for (User u : userService.getUsers()) {
            if (u.getNickname().equalsIgnoreCase(nickname)) {
                u.setLogin(true);
                return u;
            }
        }
        return null;
    }

    public Controller(List<Hotel> hotels) {
        hotelService = new HotelDAO(hotels);
    }

    public Controller() {
        hotelService = new HotelDAO();
        userService = new UserDAO();
        orderService = new OrderDAO();
    }

    public static UserDAO getUserService() {
        return userService;
    }

    public static List<Order> getOrderService() {
        return orderService.getOrders();
    }

    public static List<Hotel> getHotelService() {
        return hotelService.getHotels();
    }
}
