package com.xtkj.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class TUser {
    @TableId("ID")
    private Integer id;
    @TableField("userName")
    private String userName;
    @TableField("password")
    private String password;
    @TableField("money")
    private Double money;
}
