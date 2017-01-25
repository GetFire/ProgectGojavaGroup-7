package FinalProject;

/**
 * Created by GetFire on 15.01.2017 for ProgectGojavaGroup-7.
 * <p>
 * An instance of this class simulates user operation
 */

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


import static FinalProject.Hotel.*;


public class Controller {
    private List<Hotel> hotels = new ArrayList<>();
    private Set<User> users = new HashSet<>();
    private List<Order> orders = new ArrayList<>();
    private UserDAO userService;
    private OrderDAO orderService;
    //@добавлю DAO на будущее, потом в методах нужно использовать дао вместо поля hotels
    //private DAOImpl hotelsDao = new DAOImpl();


    public Controller(List<Hotel> hotels, Set<User> users, List<Order> orders) {
        this.hotels = hotels;
        this.users = users;
        this.orders = orders;
        this.userService = new UserDAO(users);
        this.orderService = new OrderDAO(orders);

    }

    //Find hotels by name
    public Collection<Hotel> findHotelByName(String name) {
        List<Hotel> hotel = hotels.stream().filter(a -> a.getHotelName().equals(name)).collect(Collectors.toList());
        if (hotel.size() == 0) System.out.println("Not found");
        return hotel;

    }


    // Find hotels by name city
    public Collection<Hotel> findHotelByCity(String city) {
        List<Hotel> hotel = hotels.stream().filter(a -> a.getCity().equals(city)).collect(Collectors.toList());
        if (hotel.size() == 0) System.out.println("Not found");
        return hotel;

    }


    //Booking rhe room. пока не знаю что делать с userID
    public void bookRoom(UUID roomID, UUID userID, UUID hotelID, Date startDate, int days) throws InvalidFormException {
        /*
        List<Hotel> foundedHotels = hotels.stream().filter(a -> a.getId().equals(hotelID)).collect(Collectors.toList());
        Hotel hotel = foundedHotels.get(0);
        List<Room> rooms = hotel.getRooms().stream().filter(a -> a.getId().equals(roomID)).collect(Collectors.toList());
        Room foundedRoom = rooms.get(0);
        foundedRoom.setAvaible(false);
        */
        //check: Are booked the room, or not
        List<Order> filteredOrder = orders.stream().filter(a->(a.getHotelID().equals(hotelID)&&a.getRoomID().equals(roomID))).collect(Collectors.toList());
        for (Order i: filteredOrder)
        {
            boolean flag = false;
            Calendar cal = Calendar.getInstance();
            cal.setTime(startDate);
            cal.set(Calendar.DAY_OF_MONTH,days);
            long firstDay = i.getStartDate().getTime();
            long lastDay = cal.getTime().getTime();
            for (int j = 0; j <days ; j++) {
                Calendar caltmp = Calendar.getInstance();
                caltmp.setTime(startDate);
                caltmp.set(Calendar.DAY_OF_MONTH,j);
                long currentDay = caltmp.getTime().getTime();
                if (firstDay<currentDay && currentDay<lastDay)
                {
                    throw new InvalidFormException("This dates are reserved");
                }

            }

        }
        //add order
        orderService.save(new Order(userID, hotelID,roomID, startDate,days));
    }


    // Cancel booking. пока не знаю что делать с userID
    public void cancelReservation(UUID roomID, UUID userID, UUID hotelID) throws InvalidFormException{
        //filter order from user, by hotel and room
        List<Order> filteredOrder = orders.stream().filter(a->(a.getHotelID().equals(hotelID)&&a.getRoomID().equals(roomID)&&a.getUserID().equals(userID))).collect(Collectors.toList());
        if (filteredOrder.isEmpty()) throw new InvalidFormException("Order not found, input correct data");
        else {
            //delete all filtered orders
            try {
                filteredOrder.forEach(orderService::remove);
            }
            catch (NullPointerException e)
            {
               throw new InvalidFormException(e.getMessage());
            }

        }

    }


    // пока пускай будет так
    public Collection<Room> findRoom(Map<String, String> params) {
        //подготавливаю код
//        List<Hotel>allHotels = hotelsDao.getDao();
        List<Room> found = new ArrayList<>();

        // Тут предлагаю создать свою ошибку, InvalidFormException, в том случае когда поля city и hotelName - пустые
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
                Optional<Hotel> first = hotels.stream()
                        .filter(a -> a.getCity().equals(city))
                        .filter(a -> a.getHotelName().equals(hotelName))
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
                Optional<Hotel> second = hotels.stream()
                        .filter(a -> a.getCity().equals(city))
                        .filter(a -> a.getHotelName().equals(hotelName))
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
                Optional<Hotel> third = hotels.stream()
                        .filter(a -> a.getCity().equals(city))
                        .filter(a -> a.getHotelName().equals(hotelName))
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
                Optional<Hotel> fouth = hotels.stream()
                        .filter(a -> a.getCity().equals(city))
                        .filter(a -> a.getHotelName().equals(hotelName))
                        .findFirst();
                if (fouth.isPresent()) {
                    found = fouth.get().getRooms();
                } else {
                    System.out.println("Not found. Try to change your parameters");
                }
                break;
        }

        return found;
    }


    // пока не знаю что с этим делать
    public User registerUser(User user)
    {
            if (!users.contains(user)) {
                userService.save(user);
                System.out.println("Добро пожаловать!");
            }else{
                System.out.println("С возвращением!");}
            return user;
    }


    public Controller(List<Hotel> hotels) {
        this.hotels = hotels;
    }
}
