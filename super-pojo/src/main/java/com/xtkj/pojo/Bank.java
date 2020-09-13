package com.xtkj.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("bank")
public class Bank {
    @TableId(value = "b_id",type = IdType.AUTO)
    private int id;
    @TableField("b_name")
    private String name;
    @TableField("b_money")
    private double bmoney;
    @TableField("money")
    private double money;
    @Version
    private int version;

}
