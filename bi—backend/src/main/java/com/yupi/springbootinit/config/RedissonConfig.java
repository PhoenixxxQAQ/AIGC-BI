package com.yupi.springbootinit.config;

import io.swagger.models.auth.In;
import lombok.Data;
import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedissonConfig {


    private Integer database;

    private String host;

    private Integer port;


    @Bean
    public RedissonClient RedissonClient(){
        Config config = new Config();
        config.useSingleServer()
                .setDatabase(database)
                .setAddress("redis://" + host + ":" + port);
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }

}
