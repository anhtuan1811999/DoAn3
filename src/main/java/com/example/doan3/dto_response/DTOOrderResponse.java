package com.example.doan3.dto_response;

import com.example.doan3.entity.Item;
import com.example.doan3.entity.TotalMoneyBill;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DTOOrderResponse {

    private TotalMoneyBill totalMoneyBill;
    private List<Item> items;
}
