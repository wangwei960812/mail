package com.ww.mail.feign.help;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

/**
 * @author ：黑洞里的光
 * @date ：Created in 2021/8/28 19:37
 * @description：feign接口生产工厂类
 */
public class FeignServiceFactory {

    public static <T> T createServiceWithJsonCodec(Class<T> t, String url) {
        return Feign.builder()
                //添加解码器
                .decoder(new JacksonDecoder())
                //添加编码器
                .encoder(new JacksonEncoder())
                .target(t, url);
    }
}
