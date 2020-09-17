package com.xtkj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xtkj.dao.TPreMapper;
import com.xtkj.dao.TRoleMapper;
import com.xtkj.dao.TUserMapper;
import com.xtkj.pojo.TPre;
import com.xtkj.pojo.TRole;
import com.xtkj.pojo.TUser;
import com.xtkj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements IUserService, UserDetailsService {
    @Autowired
    private TRoleMapper roleMapper;
@Autowired
    private TPreMapper preMapper;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        QueryWrapper<TUser> wrapper = new QueryWrapper();
        wrapper.eq("userName",userName);
        TUser one = getOne(wrapper);
        if (one==null)
            throw new UsernameNotFoundException("账号不存在！");
        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        List<TRole> arrs = roleMapper.getRoleByUserId(one.getId());
        for (int i = 0; i <arrs.size() ; i++) {
            TRole tRole = arrs.get(i);
            roles.add(new SimpleGrantedAuthority(tRole.getRoleName()));
        }
        Set<TPre> allpre =new HashSet<>();
        for (int i = 0; i < arrs.size(); i++) {
            TRole tRole = arrs.get(i);
            Set<TPre> pres = preMapper.getPreByRoleId(tRole.getRoleId());
            allpre.addAll(pres);
        }
        Iterator<TPre> iterator = allpre.iterator();
        while (iterator.hasNext()) {
            TPre pre = iterator.next();
            roles.add(new SimpleGrantedAuthority(pre.getPreName()));
        }
        UserDetails userDetails =  new User(userName,one.getPassword(),roles);
        return userDetails;
    }
}
