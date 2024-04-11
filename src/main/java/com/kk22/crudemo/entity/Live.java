package com.kk22.crudemo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "live")
public class Live {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "content")
    private String content;
    @OneToOne(mappedBy = "live",cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Salesperson salesperson;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.DETACH,
                    CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
            name = "live_voucher",
            joinColumns = @JoinColumn(name = "live_id"),
            inverseJoinColumns = @JoinColumn(name  = "voucher_id")
    )
    private List<Voucher> vouchers;
    public Live(){}

    public Live(String content) {
        this.content = content;
    }

    public Salesperson getSalesperson() {
        return salesperson;
    }

    public void setSalesperson(Salesperson salesperson) {
        this.salesperson = salesperson;
    }

    public List<Voucher> getVouchers() {
        return vouchers;
    }

    public void setVouchers(List<Voucher> vouchers) {
        this.vouchers = vouchers;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Live{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", salesperson=" + salesperson +
                ", vouchers=" + vouchers +
                '}';
    }
}
