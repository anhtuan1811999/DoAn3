package com.example.doan3.service;

import com.example.doan3.dto_request.DTOStatusConfirmOrder;
import com.example.doan3.dto_response.DTOOrderResponse;
import com.example.doan3.entity.TotalMoneyBill;
import com.example.doan3.repository.ItemRepository;
import com.example.doan3.repository.TotalMoneyBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void changeConfirmTotalBillStatus(DTOStatusConfirmOrder confirmOrder){
        TotalMoneyBill totalMoneyBill = totalMoneyBillRepository.findAllByBillCode(confirmOrder.getBillCode());
        if (confirmOrder.getConfirm().equals("Confirm")&& !totalMoneyBill.isConfirm()){
            totalMoneyBill.setConfirm(true);
            totalMoneyBillRepository.save(totalMoneyBill);
        } else if (confirmOrder.getConfirm().equals("Undo")&& totalMoneyBill.isConfirm()) {
            totalMoneyBill.setConfirm(false);
            totalMoneyBillRepository.save(totalMoneyBill);
        } else {
            System.out.println("Other Case");
        }
    }
}
