package com.railway.office.model;
import javax.persistence.*;

@Entity
@Table(name="passengers")

public class Passengers {
    @Id
    @Column(name = "idpass")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpass;

    @Column(name = "Family")
    private String family;

    @Column(name = "Name")
    private String name;

    @Column(name = "Passport")
    private String passport;

    @Column(name = "Sex")
    private String sex;

    public Passengers() {
    };

    public Passengers (int idpass, String family, String name, String passport, String sex)
      {
        this.idpass = idpass;
        this.family = family;
        this.name = name;
        this.passport = passport;
        this.sex = sex;
      }

    public int getIdpass() { return idpass; }

    public void setIdpass(int idpass) { this.idpass = idpass; }

    public String getFamily() { return family; }

    public void setFamily(String family) { this.family = family; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPassport() { return passport; }

    public void setPassport(String passport) { this.passport = passport; }

    public String getSex() { return sex; }

    public void setSex(String sex) { this.sex = sex; }

    @Override
    public String toString() {
        return idpass + " " + family + " " + name + " " + passport  + " " + sex;
    }

}






