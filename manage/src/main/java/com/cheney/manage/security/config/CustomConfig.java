package com.cheney.manage.security.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * CustomConfig
 *
 * @Author mineChen
 * @Date 2020/6/19 12:50
 */
@ConfigurationProperties(prefix = "custom.config")
@Data
public class CustomConfig {

    /**
     * 不需要拦截的地址
     */
    private IgnoreConfig ignores;
}
