package com.example.NettPotek;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "my_order")
public class Order {

    @Id
    @GeneratedValue
    private long id ;
    @ManyToOne
    private Costumer costumer;
    private double total ;
    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderProducts ;

    public Order() {
    }

    public Order(Costumer costumer, double total, List<OrderProduct> orderProducts) {
        this.costumer = costumer;
        this.total = total;
        this.orderProducts = orderProducts;
    }

    public double calculateTotal(){
        double sum = 0 ;
        for(int i=0; i<orderProducts.size();i++){
           sum += (orderProducts.get(i).getProduct().getPrice() ) * orderProducts.get(i).getQuantity() ;
        }

        return sum ;
    }
}
