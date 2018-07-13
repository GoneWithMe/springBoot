package com.study;

import com.study.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;

/**
 * @author liuxin
 * @Title: MailServiceTest
 * @ProjectName springBootTest
 * @Description: TODO
 * @date 2018/7/1316:10
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MailServiceTest {
    @Autowired
    private MailService MailService;
    @Autowired
    private TemplateEngine templateEngine;
    @Test
    public void testSimpleMail() throws Exception {
        MailService.sendSimpleMail("ityouknow@126.com","test simple mail"," hello this is simple mail");
    }
    @Test
    public void testHtmlMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        MailService.sendHtmlMail("ityouknow@126.com","test simple mail",content);
    }

    @Test
    public void sendAttachmentsMail() throws MessagingException {
        String filePath="e:\\tmp\\application.log";
        MailService.sendAttachmentsMail("ityouknow@126.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }
    @Test
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\Users\\summer\\Pictures\\favicon.png";

        MailService.sendInlineResourceMail("ityouknow@126.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }
    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("emailTemplate", context);

        MailService.sendHtmlMail("ityouknow@126.com","主题：这是模板邮件",emailContent);
    }
}
