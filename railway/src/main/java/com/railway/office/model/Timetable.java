package com.railway.office.model;
import javax.persistence.*;

@Entity
@Table(name="timetable")

public class Timetable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Number")
    private int number;

    @Column(name = "Start station")
    private String startstat;

    @Column(name = "End station")
    private String endstat;

    @Column(name = "Date")
    private String date;

    @Column(name = "Time of Depart")
    private String timedepart;

    @Column(name = "Time of Arrival")
    private String timearriv;

    @Column(name = "Price")
    private int price;

    public Timetable() {
    };

    public Timetable (int id, int number, String startstat, String endstat,
                   String date, String timedepart, String timearriv,
                   int price) {
        this.id = id;
        this.number = number;
        this.startstat = startstat;
        this.endstat = endstat;
        this.date = date;
        this.timedepart = timedepart;
        this.timearriv = timearriv;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStartstat() {
        return startstat;
    }

    public void setStartstat(String startstat) {
        this.startstat = startstat;
    }

    public String getEndstat() {
        return endstat;
    }

    public void setEndstat(String endstat) {
        this.endstat = endstat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimedepart() {
        return timedepart;
    }

    public void setTimedepart(String timedepart) {
        this.timedepart = timedepart;
    }

    public String getTimearriv() {
        return timearriv;
    }

    public void setTimearriv(String timearriv) {
        this.timearriv = timearriv;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + " " + number + " " + startstat + " " + endstat + " " + timedepart + " " + timedepart + " " + price;
    }

}






