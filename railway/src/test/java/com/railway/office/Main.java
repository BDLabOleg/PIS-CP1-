package com.railway.office;

import com.railway.office.dao.*;
import com.railway.office.model.Timetable;
import com.railway.office.model.Passengers;
import com.railway.office.model.Trains;
import com.railway.office.dao.TimetableDAO;
import com.railway.office.model.Trains;

import java.util.Scanner;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {


        System.out.println("Table 1. Timetable");
        List<Timetable> timetableList = TimetableDAOImpl.getAllTimetable();
        for (Timetable timetable : timetableList) {
            System.out.print("ID: " + timetable.getId() + "  ");
            System.out.print("Number: " + timetable.getNumber() + "  ");
            System.out.print("Start Station: " + timetable.getStartstat() + "  ");
            System.out.print("End Station: " + timetable.getEndstat() + "  ");
            System.out.print("Date: " + timetable.getDate() + "  ");
            System.out.print("Time of Depart: " + timetable.getTimedepart() + "  ");
            System.out.print("Time of Arrival: " + timetable.getTimearriv() + "  ");
            System.out.println("Price: " + timetable.getPrice() + "  ");

        }

        System.out.println(" ");
        System.out.println("Table 2. Passengers");

        List<Passengers> passengersList = PassengersDAOImpl.getAllPassengers();
        for (Passengers passengers : passengersList) {
            System.out.print("IDpass: " + passengers.getIdpass() + "  ");
            System.out.print("Family: " + passengers.getFamily() + "  ");
            System.out.print("Name: " + passengers.getName() + "  ");
            System.out.print("Passport: " + passengers.getPassport() + "  ");
            System.out.println("Sex: " + passengers.getSex() + "  ");
        }

        System.out.println(" ");
        System.out.println("Table 3. Trains");

        List<Trains> trainsList = TrainsDAOImpl.getAllTrains();
        for (Trains trains : trainsList) {
            System.out.print("Number: " + trains.getNumber() + "  ");
            System.out.print("Type: " + trains.getType() + "  ");
            System.out.print("Number of Cupe Tickets: " + trains.getNumbCupeTick() + "  ");
            System.out.println("Number of Platz Tickets: " + trains.getNumbPlatzTick() + "  ");
        }


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("------------------------------------------------");

        Scanner in = new Scanner(System.in);
        System.out.println("Continue to add info into Tables?");
        String name = in.nextLine();

        if (name.equals("y")) {

            System.out.println("You may add the row to Table1 as example");
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(br.readLine());
            System.out.print("Enter Number:");
            int number = Integer.parseInt(br.readLine());
            System.out.print("Enter Start Station:");
            String startstat = br.readLine();
            System.out.print("Enter End Station:");
            String endstat = br.readLine();
            System.out.print("Enter Date:");
            String date = br.readLine();
            System.out.print("Enter Time of Depart:");
            String timedepart = br.readLine();
            System.out.print("Enter Time of Arrival:");
            String timearriv = br.readLine();
            System.out.print("Enter Price:");
            int price = Integer.parseInt(br.readLine());


            //after user enters values, store them in a Office variable
            Timetable timetable = new Timetable(id, number, startstat, endstat, date, timedepart, timearriv, price);
            int status = TimetableDAOImpl.addTimetable(timetable);
            if (status == 1) {
                System.out.println("Line added successfully");
            } else {
                System.out.println("ERROR while adding line");
            }
            System.out.println("\n");
        }
    }
}

