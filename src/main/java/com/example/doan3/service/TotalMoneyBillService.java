package com.example.doan3.service;

import com.example.doan3.dto_response.DTOOrderResponse;
import com.example.doan3.entity.TotalMoneyBill;
import com.example.doan3.repository.ItemRepository;
import com.example.doan3.repository.TotalMoneyBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TotalMoneyBillService {

    @Autowired
    private TotalMoneyBillRepository totalMoneyBillRepository;

    @Autowired
    private ItemRepository itemRepository;

    public void insertTotalMoneyBillToDatabase(TotalMoneyBill totalMoneyBill){
        totalMoneyBillRepository.save(totalMoneyBill);
    }

    public List<DTOOrderResponse> getListOfOrder(){
        return totalMoneyBillRepository.findAllByStatus(true).parallelStream()
                .map(totalMoneyBill -> DTOOrderResponse.builder()
                        .totalMoneyBill(totalMoneyBill)
                        .items(itemRepository.findAllByBillCode(totalMoneyBill.getBillCode()))
                        .build()).collect(Collectors.toList());
    }

    public void changeConfirmTotalBillTrue(String code){
        TotalMoneyBill totalMoneyBill = totalMoneyBillRepository.findAllByBillCode(code);
        totalMoneyBill.setConfirm(true);
        totalMoneyBillRepository.save(totalMoneyBill);
    }

    public void changeConfirmTotalBillFalse(String code){
        TotalMoneyBill totalMoneyBill = totalMoneyBillRepository.findAllByBillCode(code);
        totalMoneyBill.setConfirm(false);
        totalMoneyBillRepository.save(totalMoneyBill);
    }
}
