package com.example.doan3.controller;

import com.example.doan3.dto_request.DTOStatusConfirmOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestCartController {

    @PostMapping(value = "/change-status-order")
    public ResponseEntity<String> changeStatusConfirmOrder(DTOStatusConfirmOrder confirmOrder){
        System.out.println(confirmOrder.getConfirm());
        System.out.println(confirmOrder.getBillCode());
        return new ResponseEntity<>("successfully",HttpStatus.ACCEPTED);
    }
}
