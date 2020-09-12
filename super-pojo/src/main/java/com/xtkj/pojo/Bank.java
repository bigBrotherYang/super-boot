package com.xtkj.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
public class Bank {
    @TableId("b_id")
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
