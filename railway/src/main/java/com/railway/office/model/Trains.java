package com.railway.office.model;
import javax.persistence.*;

@Entity
@Table(name="trains")

public class Trains {
    @Id
    @Column(name = "Number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @Column(name = "Type")
    private String type;

    @Column(name = "NumbCupeTick")
    private int numbcupetick;

    @Column(name = "NumbPlatzTick")
    private int numbplatztick;

    public Trains() {
    };

    public Trains (int number, String type, int numbcupetick, int numbplatztick)
                        {
        this.number = number;
        this.type = type;
        this.numbcupetick = numbcupetick;
        this.numbplatztick = numbplatztick;
        }

    public int getNumber() { return number; }

    public void setNumber(int number) { this.number = number; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public int getNumbCupeTick() { return numbcupetick; }

    public void setNumbCupeTick(int numbcupetick) { this.numbcupetick = numbcupetick; }

    public int getNumbPlatzTick() { return numbplatztick; }

    public void setPlatzTick(int numbplatztick) { this.numbplatztick = numbplatztick; }

    @Override
    public String toString() {
        return number + " " + type + " " + numbcupetick + " " + numbplatztick;
    }

}
