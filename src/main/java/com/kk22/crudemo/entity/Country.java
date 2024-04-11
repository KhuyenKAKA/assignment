package com.kk22.crudemo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "country_name")
    private String countryName;
    @OneToMany(mappedBy = "country",
               cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} )
    private List<Address> addresses;
    @OneToMany(mappedBy = "country",
            cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} )
    private List<City> cities;
    public Country(){

    }

    public Country(String countryName) {
        this.countryName = countryName;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<Address> getAddress() {
        return addresses;
    }

    public void setAddress(List<Address> address) {
        this.addresses = address;
    }
    public void add(Address tempAddress){
        if(addresses == null){
            addresses = new ArrayList<>();
        }
        addresses.add((tempAddress));
        tempAddress.setCountry(this);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                ", addresses=" + addresses +
                ", cities=" + cities +
                '}';
    }
}
