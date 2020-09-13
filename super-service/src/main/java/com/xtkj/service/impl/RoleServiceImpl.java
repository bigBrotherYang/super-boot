package com.xtkj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xtkj.dao.TRoleMapper;
import com.xtkj.dao.TUserMapper;
import com.xtkj.pojo.TRole;
import com.xtkj.pojo.TUser;
import com.xtkj.service.IRoleService;
import com.xtkj.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<TRoleMapper, TRole> implements IRoleService {

}
