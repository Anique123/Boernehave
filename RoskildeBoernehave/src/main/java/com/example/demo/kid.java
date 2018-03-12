package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class kid {

    private int kidId;
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date BirthDate;
    private String cpr;
    private String parentName;
    private String TLF;

    public kid(){

    }



    public kid(int kidId, String firstName, String lastName, Date BirthDate, String parentName, String TLF) {
        this.kidId = kidId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.BirthDate = BirthDate;
        this.parentName = parentName;
        this.TLF = TLF;

    }

    public kid(int kidId) {
        this.kidId = kidId;
    }

    public int getKidId() {
        return kidId;
    }

    public void setKidId(int kidId) {
        this.kidId = kidId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.BirthDate = birthDate;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentfirstName) {
        this.parentName = parentfirstName;
    }

    public String getTLF() {
        return TLF;
    }

    public void setTLF(String parentlastName) {
        this.TLF = parentlastName;
    }
    @Override
    public String toString() {
        return "kid{" +
                "kidId=" + kidId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", BirthDate=" + BirthDate +
                ", cpr='" + cpr + '\'' +
                ", parentName='" + parentName + '\'' +
                ", TLF='" + TLF + '\'' +
                '}';
    }
}