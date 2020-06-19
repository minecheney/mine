package com.cheney.common.dao;

import com.cheney.common.po.Role;

import java.util.List;

/**
 * RoleDao
 *
 * @Author mineChen
 * @Date 2020/6/19 17:05
 */
public interface RoleDao {
    List<Role> selectByUserId(Long userId);
}
