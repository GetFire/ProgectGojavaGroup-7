package FinalProject.main;


import java.util.*;


/**
 * Created by GetFire on 26.01.2017.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();
        List<Hotel> list = Controller.getHotelService();
        String userAnswer = "";
        User userMan = new User("Default", "Default", "Deafault");
        System.out.println("Чтобы перейти к поиску отелей по городам нажмите 1");
        System.out.println("Чтобы перейти к поиску отеля по названию нажмите 2");
        System.out.println("Чтобы задать параметры для комплексного поиска номера нажмите 3");
        System.out.println("Чтобы отменить бронирование нажмите 4");
        System.out.println("Чтобы войти или зарегистрироваться нажмите 5");
        System.out.println("========================================================================");
        System.out.println("Сделайте ваш выбор: ");
        userAnswer = ProjectUTILS.readString();
        if (userAnswer.equals("q"))
            System.exit(1);
        int choise = Integer.valueOf(userAnswer);
        int count=0;
        while (!userAnswer.equals("q")) {
            if (count!=0){
                choise = Integer.valueOf(userAnswer);
            }
            switch (choise) {
                case 1:
                    //clear the window
//                for (int i = 0; i < 100; i++) {
//                    System.out.println();
//                }
                    System.out.println("Доступные города: ");
                    list.forEach(a -> System.out.print(a.getCity() + ", "));
                    System.out.println();
                    //find hotel by city
                    System.out.println("Для поиска по городу введите название города: ");
                    String d = ProjectUTILS.readOnlyFillLine();
                    List<Hotel> sdf = (ArrayList<Hotel>) controller.findHotelByCity(d);
                    System.out.println(sdf);
                    break;
                case 2:
                    //clear the window
                    for (int i = 0; i < 100; i++) {
                        System.out.println();
                    }
                    System.out.println("Доступные города: ");
                    list.forEach(a -> System.out.print(a.getCity() + ", "));
                    System.out.println();
                    // find hotel by name
                    System.out.println("Введи название отеля ");
                    String s = ProjectUTILS.readOnlyFillLine();
                    sdf = (ArrayList<Hotel>) controller.findHotelByName(s);
                    System.out.println(sdf);

                    break;
                case 3:
                    //clear the window
                    for (int i = 0; i < 100; i++) {
                        System.out.println();
                    }
                    if (!userMan.getLogin()) {
                        System.out.println("Чтобы продолжить Вам нужно войти или зарегистрироваться!");
                        userMan = ProjectUTILS.userCreater();
                        System.out.println();
                    }

                    System.out.println("Доступные города: ");
                    list.forEach(a -> System.out.print(a.getCity() + ", "));
                    System.out.println();
                    Map<String, String> params = ProjectUTILS.createUsersRequest();
                    List<Room> testFound = (ArrayList<Room>) controller.findRoom(params);
                    if (testFound.size() > 0) {
                        System.out.println("Результаты поиска: ");
                        int i = 0;
                        for (Room room : testFound) {
                            System.out.println("Номер \"" + i + "\". " + room.getHotelName() + ", спальных мест " + room.getPersons() + " Цена: " + room.getPrice() + "$");
                            i++;
                        }
                    }
                    System.out.println("Желаете перейти к бронированию?");
                    System.out.println("Чтобы продолжить нажмите 1");
                    System.out.println("Для выхода введите \"q\"");
                    userAnswer = ProjectUTILS.readString();
                    System.out.println();
                    if (userAnswer.equals("q"))
                        System.exit(1);
                    else {
                        if (!userMan.getLogin()) {
                            System.out.println("Нужно залогинится!");
                            System.exit(1);
                        }
                        System.out.println("Введите порядковый номер комнаты для бронирования");
                        userAnswer = ProjectUTILS.readString();
                        if (userAnswer.equals("q"))
                            System.exit(1);
                        choise = Integer.valueOf(userAnswer);
                        Room booked = testFound.get(choise);
                        Optional<Hotel> optional = controller.findHotelByName(booked.getHotelName()).stream().filter(a -> a.getHotelName().equals(booked.getHotelName())).findFirst();
                        Hotel hotel = null;
                        if (optional.isPresent()) {
                            hotel = optional.get();
                        }
                        //UUID roomID, User user, UUID hotelID, Date startDate, int days
                        assert hotel != null;
                        controller.bookRoom(booked.getId(), userMan, hotel.getId(), new Date(), 2);
                    }
                    break;
                case 4:
                    if (!userMan.getLogin()) {
                        System.out.println("Нужно залогинится!");
                        System.exit(1);
                    }
                    User finalUserMan = userMan;
                    Order order = null;
                    Optional<Order> orderOptional = Controller.getOrderService().stream().filter(a -> a.getUserID().equals(finalUserMan.getId())).findFirst();
                    if (orderOptional.isPresent()) {
                        order = orderOptional.get();
                    }
                    //UUID roomID, User user, UUID hotelID
                    controller.cancelReservation(order.getRoomID(), userMan, order.getHotelID());
                    break;
                case 5:
                    userMan = ProjectUTILS.userCreater();
                    break;
            }
            System.out.println("Сделайте ваш выбор: ");
            userAnswer = ProjectUTILS.readString();
            count++;
        }


    }
}

