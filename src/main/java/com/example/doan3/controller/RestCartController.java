package com.example.doan3.controller;

import com.example.doan3.dto_request.DTOStatusConfirmOrder;
import com.example.doan3.service.TotalMoneyBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestCartController {

    @Autowired
    private TotalMoneyBillService totalMoneyBillService;

    @PostMapping(value = "/change-status-order")
    public ResponseEntity<String> changeStatusConfirmOrder(DTOStatusConfirmOrder confirmOrder){
        totalMoneyBillService.changeConfirmTotalBillStatus(confirmOrder);
        return new ResponseEntity<>("successfully",HttpStatus.ACCEPTED);
    }
}
