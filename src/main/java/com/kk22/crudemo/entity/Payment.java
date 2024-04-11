package com.kk22.crudemo.entity;

import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;

import java.util.List;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String paymentName;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "amount")
    private String amount;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "cus_id")
    private Customer customer;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "order_id")
    private List<Orders> orders;
    public Payment(){

    }

    public Payment(String paymentName, String paymentMethod, String amount) {
        this.paymentName = paymentName;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymentName='" + paymentName + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", amount='" + amount + '\'' +
                ", customer=" + customer +
                ", orders=" + orders +
                '}';
    }
}
