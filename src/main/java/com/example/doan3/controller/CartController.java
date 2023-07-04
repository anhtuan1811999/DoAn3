package com.example.doan3.controller;

import com.example.doan3.Util;
import com.example.doan3.dto_request.DTOItem;
import com.example.doan3.entity.Customer;
import com.example.doan3.entity.Item;
import com.example.doan3.entity.TotalMoneyBill;
import com.example.doan3.service.BillService;
import com.example.doan3.service.CustomerService;
import com.example.doan3.service.ItemService;
import com.example.doan3.service.TotalMoneyBillService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CartController {


    @Autowired
    private BillService billService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private TotalMoneyBillService totalMoneyBillService;

    @GetMapping("/cart-product")
    public String cart(HttpSession session, Model model){
        List<DTOItem> itemList = (List<DTOItem>) session.getAttribute("cart");
        if (itemList != null){
            model.addAttribute("cart", billService.getProductAndInformationRelated(itemList));
            model.addAttribute("count", Util.calculateBill(billService.getProductAndInformationRelated(itemList)));
        }
        return "cart";
    }

    @PostMapping("/cart-delete-item")
    public String deleteItem(HttpServletRequest request, HttpSession session){
        long id = Long.parseLong(request.getParameter("id"));
        List<DTOItem> listDTOItem = (List<DTOItem>) session.getAttribute("cart");

        for (DTOItem dtoItem : listDTOItem) {
            if (dtoItem.getId()==id){
                listDTOItem.remove(dtoItem);break;
            }
        }

        session.setAttribute("cart", listDTOItem);

        return "redirect:/cart-product";
    }

    @PostMapping("/payment")
    public String payForBill(HttpSession session, HttpServletRequest request){
        System.out.println("Inside Payment");
        String codeBill = Util.generateBillCode();
        List<DTOItem> dtoItemList = (List<DTOItem>) session.getAttribute("cart");
        if (dtoItemList ==null){
            return "redirect:/cart-product";
        }
        long monneyBill = Util.calculateBill(billService.getProductAndInformationRelated(dtoItemList));
        List<Item> listItem = itemService.convertListDTOItemToListItem(dtoItemList, codeBill);
        Customer customer = Customer.builder()
                .fullName(request.getParameter("customer-name"))
                .phone(request.getParameter("customer-phone"))
                .address(request.getParameter("customer-address"))
                .status(true)
                .build();
        TotalMoneyBill totalMoneyBill = TotalMoneyBill.builder()
                .customer(customer)
                .totalMoney(monneyBill)
                .status(true)
                .billCode(codeBill)
                .build();
        itemService.insertListItemToDataBase(listItem);
        customerService.insertCustomerToDatabase(customer);
        totalMoneyBillService.insertTotalMoneyBillToDatabase(totalMoneyBill);
        billService.insertBillToDatabase(listItem, customer);
        return "redirect:/home-page";
    }
}