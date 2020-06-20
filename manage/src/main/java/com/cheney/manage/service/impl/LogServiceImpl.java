package com.cheney.manage.service.impl;

import cn.hutool.json.JSONObject;
import com.cheney.common.po.Log;
import com.cheney.common.utils.StringUtils;
import com.cheney.manage.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LogServiceImpl
 *
 * @Author mineChen
 * @Date 2020/6/20 10:07
 */
@Slf4j
@Service
public class LogServiceImpl implements LogService {

    @Override
    public void save(String username, String browser, String ip, ProceedingJoinPoint joinPoint, Log sysLog) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        com.cheney.manage.annotation.Log aopLog = method.getAnnotation(com.cheney.manage.annotation.Log.class);

        // 方法路径
        String methodName = joinPoint.getTarget().getClass().getName() + "." + signature.getName() + "()";

        StringBuilder params = new StringBuilder("{");
        //参数值
        List<Object> argValues = new ArrayList<>(Arrays.asList(joinPoint.getArgs()));
        //参数名称
        for (Object argValue : argValues) {
            params.append(argValue).append(" ");
        }
        // 描述
        if (sysLog != null) {
            sysLog.setDescription(aopLog.value());
        }
        assert sysLog != null;
        sysLog.setRequestIp(ip);

        String loginPath = "login";
        if (loginPath.equals(signature.getName())) {
            try {
                username = new JSONObject(argValues.get(0)).get("username").toString();
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        sysLog.setAddress(StringUtils.getCityInfo(sysLog.getRequestIp()));
        sysLog.setMethod(methodName);
        sysLog.setUsername(username);
        sysLog.setParams(params.toString() + " }");
        sysLog.setBrowser(browser);
        // todo 插入数据库
        log.info("sysLog: {}", sysLog);
//        logRepository.save(sysLog);
    }
}
