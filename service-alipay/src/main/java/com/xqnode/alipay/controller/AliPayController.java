package com.xqnode.alipay.controller;

import cn.hutool.core.util.RandomUtil;
import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xiaqing
 */
@Slf4j
@RestController
@RequestMapping("/alipay")
public class AliPayController {

    @GetMapping("/pay")
    public String pay() {
        try {
            // 2. 发起API调用（以创建当面付收款二维码为例）
            AlipayTradePagePayResponse response = Factory.Payment.Page()
                    .asyncNotify("http://njge86.natappfree.cc/alipay/notify")
                    .pay("Apple iPhone11 128G", RandomUtil.randomNumbers(10), "999.99", "https://www.baidu.com");
            return response.getBody();
        } catch (Exception e) {
            System.err.println("调用遭遇异常，原因：" + e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @PostMapping("notify")
    public String notify(HttpServletRequest request) {
        String tradeStatus = request.getParameter("trade_status");
        if("TRADE_SUCCESS".equals(tradeStatus)) {
            log.info("pay success");
            return "success";
        }
        return "fail";
    }

}
