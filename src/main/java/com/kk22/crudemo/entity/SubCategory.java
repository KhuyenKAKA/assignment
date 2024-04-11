package com.kk22.crudemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sub_category")
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "color")
    private String color;
    @Column(name="size")
    private String size;
    @Column(name="quantity")
    private int quantity;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "product_id")
    private Product products;

    public SubCategory(){

    }

    public SubCategory(String color, String size, int quantity) {
        this.color = color;
        this.size = size;
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", quantity=" + quantity +
                ", products=" + products +
                '}';
    }
}
