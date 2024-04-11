package com.kk22.crudemo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "voucher")
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "percent_discount")
    private int percentDiscount;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.DETACH,
                    CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
            name = "live_voucher",
            joinColumns = @JoinColumn(name = "voucher_id"),
            inverseJoinColumns = @JoinColumn(name  = "live_id")
    )
    private List<Live> lives;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.DETACH,
                    CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
            name = "video_voucher",
            joinColumns = @JoinColumn(name = "voucher_id"),
            inverseJoinColumns = @JoinColumn(name  = "video_id")
    )
    private List<Video> videos;

    public Voucher(){

    }

    public Voucher(Product product, int percentDiscount) {
        this.product = product;
        this.percentDiscount = percentDiscount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Live> getLives() {
        return lives;
    }

    public void setLives(List<Live> lives) {
        this.lives = lives;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public int getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(int percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "id=" + id +
                ", product=" + product +
                ", percentDiscount=" + percentDiscount +
                ", lives=" + lives +
                ", videos=" + videos +
                '}';
    }
}
