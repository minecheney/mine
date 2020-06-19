package com.cheney.common.dao;

import com.cheney.common.po.Permission;

import java.util.List;

/**
 * PermissionDao
 *
 * @Author mineChen
 * @Date 2020/6/19 17:06
 */
public interface PermissionDao {
    List<Permission> selectByRoleIdList(List<Long> roleIds);
}
