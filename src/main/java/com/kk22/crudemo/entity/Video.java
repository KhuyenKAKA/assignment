package com.kk22.crudemo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;
    @Column(name = "description")
    private String description;
    @Column(name="comment")
    private String comment;
    @Column(name = "link_product")
    private String linkProduct;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.DETACH,
                    CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
            name = "video_voucher",
            joinColumns = @JoinColumn(name = "video_id"),
            inverseJoinColumns = @JoinColumn(name  = "voucher_id")
    )
    private List<Voucher> vouchers;
    public Video(){

    }

    public Video(String description, String comment, String linkProduct) {
        this.description = description;
        this.comment = comment;
        this.linkProduct = linkProduct;
    }

    public List<Voucher> getVouchers() {
        return vouchers;
    }

    public void setVouchers(List<Voucher> vouchers) {
        this.vouchers = vouchers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLinkProduct() {
        return linkProduct;
    }

    public void setLinkProduct(String linkProduct) {
        this.linkProduct = linkProduct;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", userAccount=" + userAccount +
                ", description='" + description + '\'' +
                ", comment='" + comment + '\'' +
                ", linkProduct='" + linkProduct + '\'' +
                ", vouchers=" + vouchers +
                '}';
    }
}
