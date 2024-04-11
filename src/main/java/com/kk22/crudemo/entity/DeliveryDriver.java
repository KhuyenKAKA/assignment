package com.kk22.crudemo.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.atn.SemanticContext;

import java.util.List;

@Entity
@Table(name="delivery_driver")
public class DeliveryDriver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "state")
    private String state;
    @OneToMany(mappedBy = "deliveryDriver",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<Orders> orders;
    public DeliveryDriver(){}

    public DeliveryDriver(String name, String phoneNumber, String state) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.state = state;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "DeliveryDriver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", state='" + state + '\'' +
                ", orders=" + orders +
                '}';
    }
}
