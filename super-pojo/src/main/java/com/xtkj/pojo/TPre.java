package com.xtkj.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tr_pre")
public class TPre {
    @TableId("pre_id")
    private Integer preId;
    @TableField("pre_name")
    private String preName;
    @TableField("pre_url")
    private String preUrl;
}
