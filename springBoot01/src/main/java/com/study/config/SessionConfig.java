package com.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by liuxin on 2018/7/9.
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 84600*30)
public class SessionConfig {
}
