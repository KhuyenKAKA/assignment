package com.kk22.crudemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "product_stars")
    private int productStars;
    @Column(name="review_line")
    private String reviewLine;
    @Column(name = "delivery_stars")
    private int deliveryStars;
    @OneToOne(mappedBy = "rating",cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private OrderStatus orderStatus;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "product_id")
    private Product products;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "cus_id")
    private Customer customer;

    public Rating(int productStars, String reviewLine, int deliveryStars) {
        this.productStars = productStars;
        this.reviewLine = reviewLine;
        this.deliveryStars = deliveryStars;
    }

    public int getProductStars() {
        return productStars;
    }

    public void setProductStars(int productStars) {
        this.productStars = productStars;
    }

    public String getReviewLine() {
        return reviewLine;
    }

    public void setReviewLine(String reviewLine) {
        this.reviewLine = reviewLine;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getDeliveryStars() {
        return deliveryStars;
    }

    public void setDeliveryStars(int deliveryStars) {
        this.deliveryStars = deliveryStars;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", productStars=" + productStars +
                ", reviewLine='" + reviewLine + '\'' +
                ", deliveryStars=" + deliveryStars +
                ", orderStatus=" + orderStatus +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
}
