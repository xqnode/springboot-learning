package com.xqnode.alipay.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "alipay")
public class AlipayProperties {
    /**
     * 应用识别码
     */
    private String appId;
    /**
     * 网关协议
     */
    private String protocol;
    /**
     * 网关地址
     */
    private String gatewayHost;
    /**
     * 密钥加密方式
     */
    private String signType;
    /**
     * 私钥
     */
    private String merchantPrivateKey;
    /**
     * 公钥
     */
    private String alipayPublicKey;
}
