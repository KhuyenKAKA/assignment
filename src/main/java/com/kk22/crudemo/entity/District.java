package com.kk22.crudemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "district")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="district_name")
    private String districtName;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "city_id")
    private City city;
    public District(){}

    public District(String districtName) {
        this.districtName = districtName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", districtName='" + districtName + '\'' +
                ", city=" + city +
                '}';
    }
}
