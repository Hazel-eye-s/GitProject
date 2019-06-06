package com.myproj.myproj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.xml.crypto.Data;

/**
 * Created by wangjinyu on 2019/5/31 14:14.
 *
 * 访问地址http://127.0.0.1:8080/swagger-ui.html#
 *
 */

@Configuration
@EnableSwagger2
public class SwaggerAutoConfiguration {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("test1")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.myproj.myproj.mq"))
                .paths(PathSelectors.any())
                .build();
    }



    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("产融协同平台对外接口")
                .description("1.提供产融协同平台使用的接口 2.提供对其他服务调用的服务\n Created by王金玉")
                //.contact(new Contact("hello world", "https://www.baidu.com", "baidu@163.com"))
                .contact(new Contact("", "", ""))
                .version("1.0")
                .build();
    }

}
