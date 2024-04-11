package com.kk22.crudemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cus_rank")
public class CusRank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="rank_name")
    private String rankName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cus_id")
    private Customer customer;

    public CusRank(){

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CusRank(String rankName, Customer customer) {
        this.rankName = rankName;
        this.customer = customer;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    @Override
    public String toString() {
        return "CusRank{" +
                "id=" + id +
                ", rankName='" + rankName + '\'' +
                ", customer=" + customer +
                '}';
    }
}
