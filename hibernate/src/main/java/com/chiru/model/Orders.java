package com.chiru.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "item")
    private String item;
    @Column(name = "price")
    private int price;
    @JoinColumn(name = "cust_id")
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Customer customer;

    // if in case order is deleted it should not delete complete details of the customer rather it should delete the speciifed order
    //if this thing has to be haapned be should not use CascadeType.ALL or  CascadeType.REMOVE on the customer in Ordersclass
    // we should use other annotations like CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH

    public Orders(int id, String item, int price) {
        this.id = id;
        this.item = item;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Orders [" + id + ", " + item + ", " + price + "]";
    }
}
