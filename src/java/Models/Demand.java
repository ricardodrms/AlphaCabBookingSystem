/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author rocharic
 */
public class Demand {
    private Customer customer;
    private String address;
    private String destination;
    private Date date;
    private Time time;
    private Status status;
    private double distance;

    //for when they are created by a customer
    public Demand(Customer customer, String address, String destination, Date date, Time time) {
        this.customer = customer;
        this.address = address;
        this.destination = destination;
        this.date = date;
        this.time = time;
        status = Status.Outstanding;
        distance = calcDistance();
    }
    
    //for use when reading from DB
    public Demand(Customer customer, String address, String destination, Date date, Time time, Status status) {
        this.customer = customer;
        this.address = address;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.status = status;
        distance = calcDistance();
    }

    public double getDistance() {
        return distance;
    }

    
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer cust) {
        this.customer = cust;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }
    
    public void setTime(Time time) {
        this.time = time;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    public double calcDistance(){
        return 0;
    }
}
