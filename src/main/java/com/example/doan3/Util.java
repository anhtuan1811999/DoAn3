package com.example.doan3;

import com.example.doan3.entity.Item;

import java.time.LocalDateTime;
import java.util.List;

public class Util {

    public static long calculateBill(List<Item> itemList){
        long moneyBill = itemList.stream().mapToLong(item -> Long.parseLong(item.getProduct().getPrice())*item.getQuantity()).sum();
        return moneyBill;
    }

    public static String generateBillCode(){
        LocalDateTime now = LocalDateTime.now();
        return "BILL" + changeIntToString(now.getYear())
                +changeIntToString(now.getMonth().getValue())
                +changeIntToString(now.getDayOfMonth())
                +changeIntToString(now.getHour())
                +changeIntToString(Integer.parseInt(now.getMinute()
                +changeIntToString(now.getSecond())));
    }

    private static String changeIntToString(int number){
        return String.valueOf(number);
    }
}