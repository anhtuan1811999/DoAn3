package com.example.doan3.service;

import com.example.doan3.dto_request.DTOItem;
import com.example.doan3.entity.Bill;
import com.example.doan3.entity.Customer;
import com.example.doan3.entity.Item;
import com.example.doan3.repository.BillRepository;
import com.example.doan3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BillRepository billRepository;

    public List<Item> getProductAndInformationRelated(List<DTOItem> dtoItemList){
        if (dtoItemList.isEmpty()){
            return new ArrayList<>();
        }
        List<Item> itemList = new ArrayList<>();
        dtoItemList.forEach(element -> itemList.add(Item.builder()
                .product(productRepository.findByIdAndStatus(element.getId(), true))
                .size(element.getSize())
                .quantity(element.getQuantity())
                .build()));
        return itemList;
    }

    public void insertBillToDatabase(List<Item> list, Customer customer){
        list.forEach(e -> billRepository.save(Bill.builder()
                        .item(e)
                        .customer(customer)
                        .status(true)
                .build()));
    }
}
