package com.huifeng.mall.admin.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class UmsAdmin implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String icon;

    @Column
    private String email;

    @Column
    private String nickName;

    @Column
    private String note;

    @Column
    private Date createTime;

    @Column
    private Date loginTime;

    @Column
    private Integer status;
}
