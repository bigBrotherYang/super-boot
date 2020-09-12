package com.xtkj.controller;

import com.xtkj.pojo.Bank;
import com.xtkj.service.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankServiceService {
    @Autowired
    private IBankService service;
    @RequestMapping("/getBanks")
    private List<Bank> getBanks(){
        return service.list();
    }
}
