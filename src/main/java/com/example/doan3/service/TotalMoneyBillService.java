package com.example.doan3.service;

import com.example.doan3.entity.TotalMoneyBill;
import com.example.doan3.repository.TotalMoneyBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TotalMoneyBillService {

    @Autowired
    private TotalMoneyBillRepository totalMoneyBillRepository;

    public void insertTotalMoneyBillToDatabase(TotalMoneyBill totalMoneyBill){
        totalMoneyBillRepository.save(totalMoneyBill);
    }
}
