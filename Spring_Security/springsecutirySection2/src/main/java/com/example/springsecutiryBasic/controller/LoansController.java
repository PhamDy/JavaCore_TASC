package com.example.springsecutiryBasic.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class LoansController {

    @GetMapping("/myLoans")
    public String getLoanDetails(){
        return "Here are the loan from the DB";
    }
}
