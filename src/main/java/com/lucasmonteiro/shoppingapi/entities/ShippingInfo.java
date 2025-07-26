package com.lucasmonteiro.shoppingapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lucasmonteiro.shoppingapi.entities.enums.ShippingType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_shipping_info")
public class ShippingInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer shippingType;
    private Double price;
    private String postalCode;
    private String adressNumber;

    //---------------------------------------Associations------------------------------------------

    @JsonIgnore
    @OneToOne
    @MapsId
    private Order order;

    //----------------------------------------------------------------------------------------------

    public ShippingInfo() {
    }

    public ShippingInfo(Long id, ShippingType shippingType, Double price, String postalCode, String adressNumber) {
        this.id = id;
        setShippingType(shippingType);
        this.price = price;
        this.postalCode = postalCode;
        this.adressNumber = adressNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShippingType getShippingType() {
        return ShippingType.valueOf(shippingType);
    }

    public void setShippingType(ShippingType shippingType) {
        if (shippingType != null) {
            this.shippingType = shippingType.getCode();
        }
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAdressNumber() {
        return adressNumber;
    }

    public void setAdressNumber(String adressNumber) {
        this.adressNumber = adressNumber;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        ShippingInfo payment = (ShippingInfo) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
