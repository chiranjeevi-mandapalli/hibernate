package com.chiru.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "roll")
    private int roll;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "marks")
    private int marks;
}
