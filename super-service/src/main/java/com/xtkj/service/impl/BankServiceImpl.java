package com.xtkj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xtkj.dao.BankMapper;
import com.xtkj.pojo.Bank;
import com.xtkj.service.IBankService;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl extends ServiceImpl<BankMapper, Bank> implements IBankService {
}
