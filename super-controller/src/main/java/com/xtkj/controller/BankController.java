package com.xtkj.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xtkj.pojo.Bank;
import com.xtkj.pojo.TUser;
import com.xtkj.service.IBankService;
import com.xtkj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/bank/login")
    public String login(String userId, String userPwd, HttpSession session){
        String json = "";
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.eq("userName",userId).eq("password",userPwd);
        TUser one = userService.getOne(wrapper);
        if (one!=null){
            session.setAttribute("USER",one);
            json="{\"msg\",\"登入成功允许跳转\"}";
        }else{
            json="{\"msg\",\"登入帐号或者密码错误\"}";
        }
        return json;
    }

    @RequestMapping("/bank/loginOut")
    public String loginOut(HttpSession session){
        session.invalidate();

        return "{\"msg\",\"退出成功\"}";
    }
}
