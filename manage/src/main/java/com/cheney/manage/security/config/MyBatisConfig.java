package com.cheney.manage.security.config;

import com.cheney.common.interceptor.SqlStatementInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfig {

    /**
     * 配置 sql打印拦截器
     * application.yml中 febs.showsql: true 时生效
     *
     * @return SqlStatementInterceptor
     */
    @Bean
    @ConditionalOnProperty(name = "mine.showsql", havingValue = "true")
    SqlStatementInterceptor sqlStatementInterceptor() {
        System.out.println("sql拦截");
        return new SqlStatementInterceptor();
    }
}
