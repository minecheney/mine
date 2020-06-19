package com.cheney.manage.security.config;

import com.cheney.common.common.Status;
import com.cheney.manage.security.util.ResponseUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * SecurityHandlerConfig
 *
 * @Author mineChen
 * @Date 2020/6/19 13:48
 */
@Configuration
public class SecurityHandlerConfig {
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) -> ResponseUtil.renderJson(response, Status.ACCESS_DENIED, null);
    }
}
