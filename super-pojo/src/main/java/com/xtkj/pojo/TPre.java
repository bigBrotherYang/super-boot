package com.xtkj.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@TableName("tr_pre")
@EqualsAndHashCode
public class TPre implements Serializable {
    private static final long serialVersionUID = 6443588411879858466L;
    @TableId("pre_id")
    private Integer preId;
    @TableField("pre_name")
    private String preName;
    @TableField("pre_url")
    private String preUrl;

}
