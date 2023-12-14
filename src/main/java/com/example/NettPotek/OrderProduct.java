package com.example.NettPotek;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderProduct {

    @Id
    @GeneratedValue
    private long id ;
    @ManyToOne
    private Order order;
    @ManyToOne
    private Product product;
    private int quantity;

    public OrderProduct() {
    }

    public OrderProduct(Order order, Product product, int quantity) {
       // this.order = order;
        this.product = product;
        this.quantity = quantity;
    }
}
