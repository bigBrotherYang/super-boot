package com.xtkj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xtkj.dao.TUserMapper;
import com.xtkj.pojo.TUser;
import com.xtkj.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements IUserService {

}
