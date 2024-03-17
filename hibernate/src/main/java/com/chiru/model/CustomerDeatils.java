package com.chiru.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customer_details")
public class CustomerDeatils {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;

    public CustomerDeatils(int id, String email, String phone, String address) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    //in order to make bidirectional flow we need to create the object of customer and use annotations
    @OneToOne(mappedBy = "customerDeatils", cascade = CascadeType.ALL)
    private Customer customer;

    @Override
    public String toString() {
        return id + ", " + email + ", " + phone + ", " + address + ", " + customer ;
    }

}
