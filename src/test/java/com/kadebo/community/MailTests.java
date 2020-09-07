package com.kadebo.community;


import com.kadebo.community.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {
    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;


    @Test
    public void testTextMail(){
        mailClient.sendMail("2857108160@qq.com","Test","lalala");
    }

    @Test
    public void testHtmlMail(){
        Context context = new Context();
        context.setVariable("username","广西仔");

        String content = templateEngine.process("/mail/demo",context);
        mailClient.sendMail("2742616708@qq.com","新程序测试",content);

    }
}
