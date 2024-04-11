package com.kk22.crudemo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "salesperson")
public class Salesperson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "sales_name")
    private String salesName;
    @Column(name = "num_of_followers")
    private int numOfFollowers;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_has_role_id")
    private UserHasRole userHasRole;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "live_id")
    private Live live;
    @OneToMany(mappedBy = "salesperson",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<Orders> orders ;
    @OneToMany(mappedBy = "salesperson",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<Product> products ;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.DETACH,
                    CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
            name = "address_sales",
            joinColumns = @JoinColumn(name = "salesperson_id"),
            inverseJoinColumns = @JoinColumn(name  = "address_id")
    )
    private List<Address> addresses;
    public Salesperson(){

    }

    public Live getLive() {
        return live;
    }

    public void setLive(Live live) {
        this.live = live;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Salesperson(String salesName, int numOfFollowers) {
        this.salesName = salesName;
        this.numOfFollowers = numOfFollowers;
    }

    public String getSalesName() {
        return salesName;
    }

    public UserHasRole getUserHasRole() {
        return userHasRole;
    }

    public void setUserHasRole(UserHasRole userHasRole) {
        this.userHasRole = userHasRole;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }

    public int getNumOfFollowers() {
        return numOfFollowers;
    }

    public void setNumOfFollowers(int numOfFollowers) {
        this.numOfFollowers = numOfFollowers;
    }

    @Override
    public String toString() {
        return "Salesperson{" +
                "id=" + id +
                ", salesName='" + salesName + '\'' +
                ", numOfFollowers=" + numOfFollowers +
                ", userHasRole=" + userHasRole +
                ", live=" + live +
                ", orders=" + orders +
                ", products=" + products +
                ", addresses=" + addresses +
                '}';
    }
}
