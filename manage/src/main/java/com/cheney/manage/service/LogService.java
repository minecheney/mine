package com.cheney.manage.service;

import com.cheney.common.po.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * LogService
 *
 * @Author mineChen
 * @Date 2020/6/20 10:06
 */
public interface LogService {
    /**
     * 保存日志数据
     * @param username 用户
     * @param browser 浏览器
     * @param ip 请求IP
     * @param joinPoint /
     * @param log 日志实体
     */
    @Async
    void save(String username, String browser, String ip, ProceedingJoinPoint joinPoint, Log log);
}
