package FinalProject;

import FinalProject.Controller.Controller;
import FinalProject.Entity.Hotel;
import FinalProject.Entity.Room;
import FinalProject.Entity.User;
import FinalProject.Services.*;

import java.util.*;

import static FinalProject.Services.ProjectUTILS.readString;

/**
 * Created by GetFire on 26.01.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();
        List<Hotel> list = Controller.getHotelService();
        String userAnswer;
        User userMan = null;
        if (userMan == null) {
            System.out.println("Sorry, you should be logged in to continue!");
            userMan = ProjectUTILS.userCreater();
            System.out.println();
        }

        System.out.println("To find hotel using city press '1'");
        System.out.println("To find hotel using hotel's name press '2'");
        System.out.println("To find hotel using detailed parameters press '3'");
        System.out.println("To cancel your booking press '4'");
        System.out.println("To sign in/sign up press '5'");
        System.out.println("========================================================================");
        System.out.println("Make your choice: ");
        int choice;

        userAnswer = ProjectUTILS.checkInt();
        choice = Integer.valueOf(userAnswer);
        int count = 0;
        while (true) {
            if (count != 0) {
                choice = Integer.valueOf(userAnswer);
            }
            switch (choice) {
                case 1:
                    //clear the window
//                for (int i = 0; i < 100; i++) {
//                    System.out.println();
//                }
                    System.out.println("Available cities: ");
                    list.forEach(a -> System.out.print(a.getCity() + ", "));
                    System.out.println();
                    //find hotel by city
                    System.out.println("Please enter the city's name: ");
                    String d = ProjectUTILS.readOnlyFillLine();
                    List<Hotel> sdf = (ArrayList<Hotel>) controller.findHotelByCity(d);
                    System.out.println(sdf);

                    System.out.println("To continue press '1'");
                    System.out.println("To exit press \"q\"");
                    userAnswer = ProjectUTILS.checkInt();
                    System.out.println();
                    break;
                case 2:
                    //clear the window
                    for (int i = 0; i < 100; i++) {
                        System.out.println();
                    }
                    System.out.println("Available hotels: ");
                    list.forEach(a -> System.out.print(a.getHotelName() + ", "));
                    System.out.println();
                    // find hotel by name
                    System.out.println("Please enter the hotel's name: ");
                    String s = ProjectUTILS.readOnlyFillLine();
                    sdf = (ArrayList<Hotel>) controller.findHotelByName(s);
                    System.out.println(sdf);
                    System.out.println("To continue press '1'");
                    System.out.println("To exit press \"q\"");
                    userAnswer = ProjectUTILS.checkInt();
                    System.out.println();

                    break;
                case 3:
                    //clear the window
                    for (int i = 0; i < 100; i++) {
                        System.out.println();
                    }


                    System.out.println("Available cities: ");
                    list.forEach(a -> System.out.print(a.getCity() + ", "));
                    System.out.println();
                    Map<String, String> params = ProjectUTILS.createUsersRequest();
                    List<Room> testFound = (ArrayList<Room>) controller.findRoom(params);
                    if (testFound.size() > 0) {
                        System.out.println("Search results: ");
                        int i = 0;
                        for (Room room : testFound) {
                            System.out.println("Room \"" + i + "\". " + room.getHotelName() + ", beds number " + room.getPersons() + " Price: " + room.getPrice() + "$");
                            i++;
                        }
                        System.out.println("Would you like to book the room?");
                        System.out.println("To continue press '1'");
                        System.out.println("To cancel press \"q\"");
                        userAnswer = ProjectUTILS.checkInt();
                        System.out.println();

                        if (!userMan.hasLoggedIN()) {
                            System.out.println("Sorry. Please log in first!");
                            System.exit(1);
                        }
                        System.out.println("Please enter the room's number for booking");

                        Room booked = null;
                        while (true) {
                            try {

                                userAnswer = ProjectUTILS.checkInt();
                                if (userAnswer.equals("-1")) {
                                    booked = null;
                                    break;
                                }
                                choice = Integer.valueOf(userAnswer);
                                booked = testFound.get(choice);
                                break;
                            } catch (IndexOutOfBoundsException e) {

//                            System.out.println("Введите существующую комнату! или '-1' для выхода из бронирования");
                                System.out.println("Please enter existing room! Press '-1' if you want to cancel you booking");
                            }
                        }
                        if (booked == null) break;
//                    System.out.println("Введите дату заселения в формате 'dd.MM.yyyy': ");
                        System.out.println("Please enter check in date in following  format: 'dd.MM.yyyy': ");
                        String readDateLine = readString();
                        Date startDate = ProjectUTILS.toDate(readDateLine);
                        System.out.println("Please enter days: ");
                        String readDaysLine = ProjectUTILS.checkInt();
                        int days = Integer.valueOf(readDaysLine);
                        //Optional<Hotel> optional = controller.findHotelByName(booked.getHotelName()).stream().filter(a -> a.getHotelName().equals(booked.getHotelName())).findFirst();
                        Optional<Hotel> optional = controller.findHotelByName(booked.getHotelName()).stream().findFirst();
                        Hotel hotel = null;
                        if (optional.isPresent()) {
                            hotel = optional.get();
                        }
                        //UUID roomID, User user, UUID hotelID, Date startDate, int days
                        assert hotel != null;
                        try {
                            controller.bookRoom(booked.getId(), userMan, hotel.getId(), startDate, days);

                            System.out.println("To continue press '1'");
                            System.out.println("To exit press \"q\"");
                            userAnswer = ProjectUTILS.checkInt();
                            System.out.println();
                        } catch (InvalidFormException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("To continue press '1'");
                        System.out.println("To exit press \"q\"");
                        userAnswer = ProjectUTILS.checkInt();
                        System.out.println();
                    }
                    break;
                case 4:

                    System.out.println("Input hotel ID: ");
                    String hotelCancel;
                    hotelCancel = readString();
                    System.out.println("Input room ID: ");
                    String roomCancel;
                    roomCancel = readString();
                    UUID roomCancerID = null;
                    UUID hotelCancelID = null;
                    try {
                         roomCancerID = UUID.fromString(roomCancel);
                         hotelCancelID = UUID.fromString(hotelCancel);
                    }
                    catch (IllegalArgumentException iae)
                    {
                        System.out.println("Bad UUID. Try again!");
                        break;
                    }
                    //UUID roomID, User user, UUID hotelID
                    try {
                        controller.cancelReservation(roomCancerID, userMan, hotelCancelID);
                        System.out.println("To continue press '1'");
                        System.out.println("To exit press \"q\"");
                        userAnswer = ProjectUTILS.checkInt();
                        System.out.println();
                    } catch (InvalidFormException e) {
                        System.out.println(e.getMessage());

                    }

                    break;
                case 5:
                    userMan = ProjectUTILS.userCreater();
                    break;
            }
            System.out.println("To find hotel using city press '1'");
            System.out.println("To find hotel using hotel's name press '2'");
            System.out.println("To find hotel using detailed parameters press '3'");
            System.out.println("To cancel your booking press '4'");
            System.out.println("To sign in/sign up press '5'");
            System.out.println("========================================================================");
            System.out.println("Make your choice: ");
            userAnswer = ProjectUTILS.checkInt();
            count++;
        }
    }
}