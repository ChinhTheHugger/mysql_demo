package com.test_mysql_connection.mysql_demo.entity;

import java.time.LocalDateTime;
import javax.persistence.*;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.*;
import jakarta.persistence.Id;
import lombok.*;
//need to add dependencies for javax.persistence, org.springframewor.data, lombok in pom.xml to use these packages

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "customer_apartment_test")
public class CustomerAndApartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String customer_id;
    private String customer_name;
    private String customer_phone;
    private String apartment_id;
    private String apartment_name;
    private String apartment_building;
    private String apartment_floor;
    private String apartment_room;
}
