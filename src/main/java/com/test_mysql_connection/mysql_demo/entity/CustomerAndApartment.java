package com.test_mysql_connection.mysql_demo.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_apartment_test")
public class CustomerAndApartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String customer_id;
    @Column
    private String customer_name;
    @Column
    private String customer_phone;
    @Column
    private String apartment_id;
    @Column
    private String apartment_name;
    @Column
    private String apartment_building;
    @Column
    private String apartment_floor;
    @Column
    private String apartment_room;
}
