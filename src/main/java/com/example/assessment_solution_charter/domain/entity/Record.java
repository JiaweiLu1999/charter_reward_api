package com.example.assessment_solution_charter.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "record")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;

    @Column(name = "customer_id")
    String customerId;

    @Column(name = "total")
    Double total;

    @Column(name = "time")
    Timestamp time;
}
