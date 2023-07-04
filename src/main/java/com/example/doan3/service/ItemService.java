package com.example.doan3.service;

import com.example.doan3.dto_request.DTOItem;
import com.example.doan3.entity.Item;
import com.example.doan3.repository.ItemRepository;
import com.example.doan3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Item> convertListDTOItemToListItem(List<DTOItem> list, String billCode){
        List<Item> itemList = new ArrayList<>();
        list.forEach(e -> itemList.add(Item.builder()
                        .product(productRepository.findByIdAndStatus(e.getId(),true))
                        .size(e.getSize())
                        .quantity(e.getQuantity())
                        .billCode(billCode)
                        .status(true)
                .build()));
        return itemList;
    }

    public void insertListItemToDataBase(List<Item> list){
        list.forEach(e -> itemRepository.save(e));
    }
}
