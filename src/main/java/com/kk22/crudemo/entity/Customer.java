package com.kk22.crudemo.entity;

import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;

import java.util.List;
import java.util.Random;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "cus_name")
    private String cusName;
    @Column(name = "num_of_followers")
    private int numOfFollowers;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "user_has_role_id")
    private UserHasRole userHasRole;
    @OneToOne(mappedBy = "customer",cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private ShoppingBasket shoppingBasket;
    @OneToMany(mappedBy = "customer",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<Rating> ratings;
    @OneToMany(mappedBy = "customer",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<Orders> orders;
    @OneToMany(mappedBy = "customer",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<Payment> payments;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.DETACH,
                    CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
            name = "address_cus",
            joinColumns = @JoinColumn(name = "cus_id"),
            inverseJoinColumns = @JoinColumn(name  = "address_id")
    )
    private List<Address> addresses;
    public Customer(){}

    public Customer(String cusName, int numOfFollowers) {
        this.cusName = cusName;
        this.numOfFollowers = numOfFollowers;
    }

    public ShoppingBasket getShoppingBasket() {
        return shoppingBasket;
    }

    public void setShoppingBasket(ShoppingBasket shoppingBasket) {
        this.shoppingBasket = shoppingBasket;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public UserHasRole getUserHasRole() {
        return userHasRole;
    }

    public void setUserHasRole(UserHasRole userHasRole) {
        this.userHasRole = userHasRole;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public int getNumOfFollowers() {
        return numOfFollowers;
    }

    public void setNumOfFollowers(int numOfFollowers) {
        this.numOfFollowers = numOfFollowers;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", cusName='" + cusName + '\'' +
                ", numOfFollowers=" + numOfFollowers +
                ", userHasRole=" + userHasRole +
                ", shoppingBasket=" + shoppingBasket +
                ", ratings=" + ratings +
                ", orders=" + orders +
                ", payments=" + payments +
                ", addresses=" + addresses +
                '}';
    }
}
