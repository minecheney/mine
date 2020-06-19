package com.cheney.common.po;

import lombok.Data;

/**
 * Role
 *
 * @Author mineChen
 * @Date 2020/6/19 17:02
 */
@Data
public class Role {

    private Long id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;
}
