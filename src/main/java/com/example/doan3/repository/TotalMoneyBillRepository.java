package com.example.doan3.repository;

import com.example.doan3.entity.TotalMoneyBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalMoneyBillRepository extends JpaRepository<TotalMoneyBill,Long> {


}
