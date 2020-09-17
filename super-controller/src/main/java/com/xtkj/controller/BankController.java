package com.xtkj.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xtkj.pojo.Bank;
import com.xtkj.pojo.TUser;
import com.xtkj.service.IBankService;
import com.xtkj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class BankController {
    @Autowired
    private IBankService bankService;
    @Autowired
    private IUserService userService;

    @RequestMapping("/getBanks")
    private List<Bank> getBanks(){
        return bankService.list();
    }


}
