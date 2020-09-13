package com.xtkj.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("tb_role")
@Data
public class TRole {
    @TableId("role_id")
    private Integer roleId;
    @TableField("role_name")
    private String roleName;
}
