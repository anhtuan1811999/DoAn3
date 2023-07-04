package com.example.doan3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "total_money_bill")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TotalMoneyBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Customer customer;
    private Long totalMoney;
    private String billCode;
    private boolean status;

}
