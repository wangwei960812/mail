package com.ww.mail.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    /**
     * api接口包扫描路径
     */
    private static final String SWAGGER_SCAN_BASE_PACKAGE = "com.ww";

    @Value("${swagger2.version:1.0.0}")
    private String version;

    @Value("${spring.application.name:''}")
    private String title;

    @Value("${swagger2.serviceUrl:https://github.com/springfox/springfox}")
    private String termsOfServiceUrl;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any())// 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title + " API接口文档") //设置文档的标题
                .description(title + " API接口文档") // 设置文档的描述
                .version(version) // 设置文档的版本信息-> 1.0.0 Version information
                .termsOfServiceUrl(termsOfServiceUrl) // 设置文档的License信息->1.3 License information
                .build();
    }
}