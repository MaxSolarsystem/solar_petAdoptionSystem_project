package com.solar.petadoptionsystem.common.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类，注册web层相关组件
 */
@Configuration
public class WebMvcConfiguration {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("宠物领养系统接口文档")
                        .description("这是宠物领养系统的接口文档，包括 客户端，管理端的所有接口")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Leo")
                                .email("renyh2001@163.com.com")
                        )
                );
    }
}
