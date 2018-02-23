package com.xin.utils;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 电子邮件工具类
 *
 * @author Administrator
 */
public class MailUtil {
    public static final String SENDER;
    public static final String PASSWORD;
    public static final String HOST;
    public static final String PROTOCOL;
    public static final String RECEIVER;
    static {
        Properties properties = new Properties();
        //配置文件设置发件人及收件人等
        InputStream is = MailUtil.class.getResourceAsStream("/mail.properties");
        try {
            properties.load(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SENDER = properties.get("sender").toString();
        PASSWORD = properties.get("password").toString();
        HOST = properties.get("host").toString();
        PROTOCOL = properties.get("protocol").toString();
        RECEIVER = properties.get("receiver").toString();
    }

    /**
     * 发送电子邮件
     *
     * @param addr    收件人地址
     * @param subject 主题
     * @param text    内容
     * @throws MessagingException
     */
    public static void sendMail(String addr, String subject, String text) throws MessagingException {
        //设置属性
        Properties props = new Properties();
        props.put("mail.smtp.host", HOST);
        //指定认证
        props.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(props);
        session.setDebug(true);
        //构造信息体 
        MimeMessage message = new MimeMessage(session);
        //发件地址 
        Address address = new InternetAddress(SENDER);
        message.setFrom(address);
        //收件地址 
        Address toAddress = new InternetAddress(addr);
        message.setRecipient(MimeMessage.RecipientType.TO, toAddress);
        //主题 
        message.setSubject(subject);
        //正文 
        message.setText(text);
        message.saveChanges();
        Transport transport = session.getTransport(PROTOCOL);
        //连接邮箱服务器
        transport.connect(HOST, SENDER, PASSWORD);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    public static void main(String[] args) throws MessagingException {
        MailUtil.sendMail(RECEIVER,"测试","测试1234");
    }
}
