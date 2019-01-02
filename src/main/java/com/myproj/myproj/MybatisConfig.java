package com.myproj.myproj;

import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 292634839-NB on 2018/7/15.
 */
@Configuration
public class MybatisConfig {

    @Bean
    public ConfigurationCustomizer mybatisConfigurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                  configuration.setObjectWrapperFactory(new MapWrapperFactory());
               // System.out.println("*********");
//                configuration.setCacheEnabled(true);
//                configuration.setMapUnderscoreToCamelCase(true);
//                configuration.setCallSettersOnNulls(true);
//                configuration.setJdbcTypeForNull(JdbcType.NULL);
            }
        };
    }
}
