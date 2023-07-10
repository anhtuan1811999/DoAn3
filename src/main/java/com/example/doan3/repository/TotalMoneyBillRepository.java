package com.example.doan3.repository;

import com.example.doan3.entity.TotalMoneyBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TotalMoneyBillRepository extends JpaRepository<TotalMoneyBill,Long> {

    List<TotalMoneyBill> findAllByStatus(boolean status);

    TotalMoneyBill findAllByBillCode(String code);
}
