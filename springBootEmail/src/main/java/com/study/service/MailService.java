package com.study.service;

/**
 * @author liuxin
 * @Title: MailService
 * @ProjectName springBootTest
 * @Description: TODO
 * @date 2018/7/1316:08
 */
public interface MailService {
    void sendSimpleMail(String to, String subject, String content);
    void sendHtmlMail(String to, String subject, String content);
    void sendAttachmentsMail(String to, String subject, String content, String filePath);
    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
