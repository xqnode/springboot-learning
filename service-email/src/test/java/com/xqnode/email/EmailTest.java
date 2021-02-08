package com.xqnode.email;

import com.xqnode.email.service.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void testTextMail() {
        emailService.sendSimpleMail("xqnode@163.com", "测试纯文本邮件", "测试测试");
    }

    @Test
    public void testHtmlMail() {
        emailService.sendHtmlMail("xqnode@163.com", "测试Html邮件", "<h1>测试测试</h1>");
    }

    @Test
    public void testFileMail() {
        emailService.sendAttachmentsMail("xqnode@163.com", "测试附件邮件", "请看附件", "D:\\geek.exe");
    }

    @Test
    public void testImgMail() {
        String rscId = "xqnode";
        emailService.sendInlineResourceMail("xqnode@163.com",
                "嵌入静态资源的邮件",
                "<html><body>这是有嵌入静态资源：<img src=\'cid:" + rscId + "\' ></body></html>",
                "D:\\1.jpg",
                rscId);
    }
}
