package com.kk22.crudemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "warehouse")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "warehouse_address")
    private String warehouseAddress;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "delivery_id")
    private DeliveryDriver deliveryDriver;
    public Warehouse(){

    }

    public Warehouse(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public DeliveryDriver getDeliveryDriver() {
        return deliveryDriver;
    }

    public void setDeliveryDriver(DeliveryDriver deliveryDriver) {
        this.deliveryDriver = deliveryDriver;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", warehouseAddress='" + warehouseAddress + '\'' +
                ", deliveryDriver=" + deliveryDriver +
                '}';
    }
}
