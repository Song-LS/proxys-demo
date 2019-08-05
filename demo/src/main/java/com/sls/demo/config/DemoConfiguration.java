package com.sls.demo.config;

import com.sls.common.core.ProxyRegister;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sls
 **/
@Configuration
public class DemoConfiguration {

    @Bean
    public ProxyRegister proxyRegister() {
        return new ProxyRegister("com.sls.demo.service");
    }
}
