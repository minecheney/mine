package com.cheney.common.dao;

import com.cheney.common.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

/**
 * UserDao
 *
 * @Author mineChen
 * @Date 2020/6/19 19:22
 */
public interface UserDao {
    Optional<User> findByUsernameOrEmailOrPhone(@Param("username") String username, @Param("email") String email, @Param("phone") String phone);
}
