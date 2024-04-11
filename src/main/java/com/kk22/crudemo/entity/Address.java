package com.kk22.crudemo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="street_name")
    private String streetName;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "country_id")
    private Country country;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.DETACH,
                    CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
            name = "address_cus",
            joinColumns = @JoinColumn(name = "address_id"),
            inverseJoinColumns = @JoinColumn(name  = "cus_id")
    )
    private List<Customer> customers;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.DETACH,
                    CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
            name = "address_sales",
            joinColumns = @JoinColumn(name = "address_id"),
            inverseJoinColumns = @JoinColumn(name  = "salesperson_id")
    )
    private List<Salesperson> salespersons;
    public Address(){

    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Salesperson> getSalespersons() {
        return salespersons;
    }

    public void setSalespersons(List<Salesperson> salespersons) {
        this.salespersons = salespersons;
    }

    public Address(String streetName) {
        this.streetName = streetName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", streetName='" + streetName + '\'' +
                ", country=" + country +
                ", customers=" + customers +
                ", salespersons=" + salespersons +
                '}';
    }
}
