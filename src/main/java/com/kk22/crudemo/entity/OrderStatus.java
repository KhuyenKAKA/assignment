package com.kk22.crudemo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="order_status")
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "status_name")
    private String statusName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id")
    private Rating rating;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.DETACH,
                    CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
            name = "order_status_orders",
            joinColumns = @JoinColumn(name = "order_status_id"),
            inverseJoinColumns = @JoinColumn(name  = "orders_id")
    )
    private List<Orders> orders;
    public OrderStatus(){}

    public OrderStatus(String statusName, Rating rating) {
        this.statusName = statusName;
        this.rating = rating;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public OrderStatus(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "OrderStatus{" +
                "id=" + id +
                ", statusName='" + statusName + '\'' +
                ", rating=" + rating +
                ", orders=" + orders +
                '}';
    }
}
