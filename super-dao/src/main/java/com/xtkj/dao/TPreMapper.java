package com.xtkj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xtkj.pojo.TPre;
import com.xtkj.pojo.TRole;

import java.util.Set;

public interface TPreMapper extends BaseMapper<TPre> {
    Set<TPre> getPreByRoleId(int id);
}
