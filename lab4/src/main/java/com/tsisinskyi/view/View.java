package com.tsisinskyi.view;

import com.tsisinskyi.controller.impl.*;
import com.tsisinskyi.model.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.out;

public class View {
    private static final String KEY_EXIT = "Q";
    private final static Scanner scanner = new Scanner(System.in);
    private final Map<String, Printable> menu = new HashMap<>();

    private final ChainController chainController = new ChainController();
    private final EnterpriseController enterpriseController = new EnterpriseController();
    private final CityController cityController = new CityController();
    private final DistrictController districtController = new DistrictController();
    private final StreetAddressController streetAddressController = new StreetAddressController();
    private final ParkingController parkingController = new ParkingController();
    private final ParkingReservationController parkingReservationController = new ParkingReservationController();
    private final UserCardController userCardController = new UserCardController();
    private final ParkingStoryController parkingStoryController = new ParkingStoryController();

    public View() {
        menu.put("11", this::getAllChain);
        menu.put("12", this::getChainById);
        menu.put("13", this::createChain);
        menu.put("14", this::updateChain);
        menu.put("15", this::deleteChain);

        menu.put("21", this::getAllEnterprise);
        menu.put("22", this::getEnterpriseById);
        menu.put("23", this::createEnterprise);
        menu.put("24", this::updateEnterprise);
        menu.put("25", this::deleteEnterprise);

        menu.put("31", this::getAllCities);
        menu.put("32", this::getCityByName);
        menu.put("33", this::createCity);
        menu.put("35", this::deleteCity);

        menu.put("41", this::getAllDistrict);
        menu.put("42", this::getDistrictByName);
        menu.put("43", this::createDistrict);
        menu.put("45", this::deleteDistrict);

        menu.put("51", this::getAllStreetAddress);
        menu.put("52", this::getStreetAddressByName);
        menu.put("53", this::createStreetAddress);
        menu.put("55", this::deleteStreetAddress);

        menu.put("61", this::getAllParking);
        menu.put("62", this::getParkingById);
        menu.put("63", this::createParking);
        menu.put("64", this::updateParking);
        menu.put("65", this::deleteParking);

        menu.put("71", this::getAllParkingReservation);
        menu.put("72", this::getParkingReservationById);
        menu.put("73", this::createParkingReservation);
        menu.put("74", this::updateParkingReservation);
        menu.put("75", this::deleteParkingReservation);

        menu.put("81", this::getAllUserCard);
        menu.put("82", this::getUserCardById);
        menu.put("83", this::createUserCard);
        menu.put("84", this::updateUserCard);
        menu.put("85", this::deleteUserCard);

        menu.put("91", this::getAllParkingStory);
        menu.put("92", this::getParkingStoryById);
        menu.put("93", this::createParkingStory);
        menu.put("94", this::updateParkingStory);
        menu.put("95", this::deleteParkingStory);
    }

    private void getAllParkingStory() throws SQLException {
        parkingStoryController.findAll().forEach(out::println);
        massageItsAll();
    }

    private void getParkingStoryById() throws SQLException {
        out.println(parkingStoryController.findById(getId()));
        massageItsAll();
    }

    private void createParkingStory() throws SQLException {
        parkingStoryController.create(getParkingStoryFromInput());
        massageCreated();
    }

    private void updateParkingStory() throws SQLException {
        Integer id = getId();
        ParkingStory parkingStory = getParkingStoryFromInput();
        parkingStory.setId(id);
        parkingStoryController.update(parkingStory.getId(), parkingStory);
        massageUpdate();
    }

    private void deleteParkingStory() throws SQLException {
        parkingStoryController.delete(getId());
        massageDeleted();
    }

    private ParkingStory getParkingStoryFromInput() {
        out.println("Parking id: ");
        Integer parking_id = Integer.parseInt(scanner.nextLine());
        out.println("User card id: ");
        Integer user_card_id = Integer.parseInt(scanner.nextLine());
        out.println("Number car: ");
        String number_car = scanner.nextLine();
        out.println("Action: ");
        String action = scanner.nextLine();
        out.println("Timestamp: ");
        String timestamp = scanner.nextLine();
        return new ParkingStory(parking_id, user_card_id, number_car, action, timestamp);
    }

    private void getAllUserCard() throws SQLException {
        userCardController.findAll().forEach(out::println);
        massageItsAll();
    }

    private void getUserCardById() throws SQLException {
        out.println(userCardController.findById(getId()));
        massageItsAll();
    }

    private void createUserCard() throws SQLException {
        userCardController.create(getUserCardFromInput());
        massageCreated();
    }

    private void updateUserCard() throws SQLException {
        Integer id = getId();
        UserCard userCard = getUserCardFromInput();
        userCard.setId(id);
        userCardController.update(userCard.getId(), userCard);
        massageUpdate();
    }

    private void deleteUserCard() throws SQLException {
        userCardController.delete(getId());
        massageDeleted();
    }

    private UserCard getUserCardFromInput() {
        out.println("Name: ");
        String name = scanner.nextLine();
        out.println("Surname: ");
        String surname = scanner.nextLine();
        out.println("Phone number: ");
        Long phone_number = Long.parseLong(scanner.nextLine());
        out.println("Enterprise id: ");
        Integer enterprise_id = Integer.parseInt(scanner.nextLine());
        out.println("Regular user: ");
        Boolean regular_user = Boolean.parseBoolean(scanner.nextLine());
        return new UserCard(name, surname, phone_number, enterprise_id, regular_user);
    }

    private void getAllParkingReservation() throws SQLException {
        parkingReservationController.findAll().forEach(out::println);
        massageItsAll();
    }

    private void getParkingReservationById() throws SQLException {
        out.println(parkingReservationController.findById(getId()));
        massageItsAll();
    }

    private void createParkingReservation() throws SQLException {
        parkingReservationController.create(getParkingReservationFromInput());
        massageCreated();
    }

    private void updateParkingReservation() throws SQLException {
        Integer id = getId();
        ParkingReservation parkingReservation = getParkingReservationFromInput();
        parkingReservation.setId(id);
        parkingReservationController.update(parkingReservation.getId(), parkingReservation);
        massageUpdate();
    }

    private void deleteParkingReservation() throws SQLException {
        parkingReservationController.delete(getId());
        massageDeleted();
    }

    private ParkingReservation getParkingReservationFromInput() {
        out.println("Car number: ");
        String car_number = scanner.nextLine();
        out.println("Time: ");
        String time = scanner.nextLine();
        out.println("Parking id: ");
        Integer parking_id = Integer.parseInt(scanner.nextLine());
        return new ParkingReservation(car_number, time, parking_id);
    }

    private void getAllParking() throws SQLException {
        parkingController.findAll().forEach(out::println);
        massageItsAll();
    }

    private void getParkingById() throws SQLException {
        out.println(parkingController.findById(getId()));
        massageItsAll();
    }

    private void createParking() throws SQLException {
        parkingController.create(getParkingFromInput());
        massageCreated();
    }

    private void updateParking() throws SQLException {
        Integer id = getId();
        Parking parking = getParkingFromInput();
        parking.setId(id);
        parkingController.update(parking.getId(), parking);
        massageUpdate();
    }

    private void deleteParking() throws SQLException {
        parkingController.delete(getId());
        massageDeleted();
    }

    private Parking getParkingFromInput() {
        out.println("Total_number: ");
        Integer total_number = Integer.parseInt(scanner.nextLine());
        out.println("Price_per_hour: ");
        Integer price_per_hour = Integer.parseInt(scanner.nextLine());
        out.println("Street_address_name:");
        String street_address_name = scanner.nextLine();
        out.println("District_name:");
        String district_name = scanner.nextLine();
        out.println("City_name:");
        String city_name = scanner.nextLine();
        out.println("Chain_id:");
        Integer chain_id = Integer.parseInt(scanner.nextLine());
        return new Parking(total_number, price_per_hour, street_address_name, district_name, city_name, chain_id);
    }

    private void getAllStreetAddress() throws SQLException {
        streetAddressController.findAll().forEach(out::println);
        massageItsAll();

    }

    private void getStreetAddressByName() throws SQLException {
        out.println(streetAddressController.findByName(getName()));
        massageItsAll();
    }

    private void createStreetAddress() throws SQLException {
        streetAddressController.create(getStreetAddressInputs());
        massageCreated();
    }

    private void deleteStreetAddress() throws SQLException {
        streetAddressController.delete(getName());
        massageDeleted();
    }

    private StreetAddress getStreetAddressInputs() {
        out.println("Name:");
        String name = scanner.nextLine();
        return new StreetAddress(name);
    }

    private void getAllDistrict() throws SQLException {
        districtController.findAll().forEach(out::println);
        massageItsAll();

    }

    private void getDistrictByName() throws SQLException {
        out.println(districtController.findByName(getName()));
        massageItsAll();
    }

    private void createDistrict() throws SQLException {
        districtController.create(getDistrictInputs());
        massageCreated();
    }

    private void deleteDistrict() throws SQLException {
        districtController.delete(getName());
        massageDeleted();

    }

    private District getDistrictInputs() {
        out.println("Name:");
        String name = scanner.nextLine();
        return new District(name);
    }

    private void getAllCities() throws SQLException {
        cityController.findAll().forEach(out::println);
        massageItsAll();

    }

    private void getCityByName() throws SQLException {
        out.println(cityController.findByName(getName()));
        massageItsAll();
    }

    private void createCity() throws SQLException {
        cityController.create(getCityInputs());
        massageCreated();
    }

    private void deleteCity() throws SQLException {
        cityController.delete(getName());
        massageDeleted();
    }

    private City getCityInputs() {
        out.println("Name:");
        String name = scanner.nextLine();
        return new City(name);
    }

    private void getAllEnterprise() throws SQLException {
        enterpriseController.findAll().forEach(out::println);
        massageItsAll();
    }

    private void getEnterpriseById() throws SQLException {
        out.println(enterpriseController.findById(getId()));
        massageItsAll();
    }

    private void createEnterprise() throws SQLException {
        enterpriseController.create(getEnterpriseFromInput());
        massageCreated();
    }

    private void updateEnterprise() throws SQLException {
        Integer id = getId();
        Enterprise enterprise = getEnterpriseFromInput();
        enterprise.setId(id);
        enterpriseController.update(enterprise.getId(), enterprise);
        massageUpdate();
    }

    private void deleteEnterprise() throws SQLException {
        enterpriseController.delete(getId());
        massageDeleted();
    }

    private Enterprise getEnterpriseFromInput() {
        out.println("Name:");
        String name = scanner.nextLine();
        return new Enterprise(name);
    }

    private void getAllChain() throws SQLException {
        chainController.findAll().forEach(out::println);
        massageItsAll();
    }

    private void getChainById() throws SQLException {
        out.println(chainController.findById(getId()));
        massageItsAll();
    }

    private void createChain() throws SQLException {
        chainController.create(getChainFromInput());
        massageCreated();
    }

    private void updateChain() throws SQLException {
        Integer id = getId();
        Chain chain = getChainFromInput();
        chain.setId(id);
        chainController.update(chain.getId(), chain);
        massageUpdate();
    }

    private void deleteChain() throws SQLException {
        chainController.delete(getId());
        massageDeleted();
    }

    private Chain getChainFromInput() {
        out.println("Name:");
        String name = scanner.nextLine();
        return new Chain(name);
    }

    private Integer getId() {
        out.println("Id:");
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

    private String getName() {
        out.println("Name:");
        return scanner.nextLine();
    }

    private void massageItsAll() {
        out.println("----------------------------------------\n"
                + "That's all!\n"
                + "----------------------------------------\n" + "Select a table and action: ");
    }

    private void massageDeleted() {
        out.println("Deleted!\n" + "----------------------------------------\n" + "Select a table and action: ");
    }

    private void massageCreated() {
        out.println("Created!\n" + "----------------------------------------\n" + "Select a table and action: ");
    }

    private void massageUpdate() {
        out.println("Update!\n" + "----------------------------------------\n" + "Select a table and action: ");
    }

    private static void displayMenu() {
        out.println(
                "|--------------------------------------|---------------|\n" +
                        "| 1: chain                             |   1: GET ALL  |\n" +
                        "| 2: enterprise                        |   2: GET      |\n" +
                        "| 3: city                              |   3: CREATE   |\n" +
                        "| 4: district                          |   4: UPDATE   |\n" +
                        "| 5: street address                    |   5: DELETE   |\n" +
                        "| 6: parking                           |_______________|\n" +
                        "| 7: parking reservation               |               |\n" +
                        "| 8: user card                         |               |\n" +
                        "| 9: parking story                     |   Q - exit    |\n" +
                        "|--------------------------------------|---------------|\n"
        );
    }

    public void show() throws SQLException {
        displayMenu();
        out.println("Select a table and action: ");
        String input = scanner.nextLine();

        while (!input.equals(KEY_EXIT)) {
            out.println("----------------------------------------");
            menu.get(input).print();
            input = scanner.nextLine();
        }
    }

}

