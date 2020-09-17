package com.xtkj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xtkj.pojo.TRole;

import java.util.List;

public interface TRoleMapper extends BaseMapper<TRole> {

    List<TRole> getRoleByUserId(Integer userID);

}
