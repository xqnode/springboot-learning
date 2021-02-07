package com.xqnode.alipay.config;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AliPayConfig {

    @Bean
    public Config getConfig(@Autowired AlipayProperties properties) {
        Config config = new Config();
        // 网关协议
        config.protocol = properties.getProtocol().trim();
        // 网关地址
        config.gatewayHost = properties.getGatewayHost().trim();
        // 密钥加密方式
        config.signType = properties.getSignType().trim();

        // 应用识别码APPID
        config.appId = properties.getAppId().trim();
        // 应用私钥
        config.merchantPrivateKey = properties.getMerchantPrivateKey().trim();
        // 支付宝公钥
        config.alipayPublicKey = properties.getAlipayPublicKey().trim();

        // Factory全局只需配置一次
        Factory.setOptions(config);
        return config;
    }
}

