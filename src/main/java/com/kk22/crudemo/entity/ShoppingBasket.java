package com.kk22.crudemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "shopping_basket")
public class ShoppingBasket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "state")
    private String state;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cus_id")
    private Customer customer;
    public ShoppingBasket(){

    }

    public ShoppingBasket(int quantity, String state) {
        this.quantity = quantity;
        this.state = state;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "ShoppingBasket{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", state='" + state + '\'' +
                ", customer=" + customer
                ;
    }
}

