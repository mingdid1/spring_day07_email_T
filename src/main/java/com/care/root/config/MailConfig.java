package com.care.root.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	@Bean
	public static JavaMailSender mailSender() {
		JavaMailSenderImpl jms = new JavaMailSenderImpl();
		jms.setHost("smtp.gmail.com");//google smtp ���� ����
		jms.setPort(587);//google smtp ���� ���� ��Ʈ
		jms.setUsername("choheewon00@gmail.com");//������ ����
		jms.setPassword("evsfeylqqsexyyut");

		//���� ���� �������� ���� ����
		Properties prop = new Properties();
		prop.setProperty("mail.transport.protocol", "smtp");
		//true�� ����� ������ �õ��Ѵ�.
		prop.setProperty("mail.smtp.auth", "true"); 
		//tls ������� ó���Ǹ� ����� ����ó���̴�. �Ͻ�����ssl�̴�
		prop.setProperty("mail.smtp.starttls.enable", "true");
		jms.setJavaMailProperties(prop);

		return jms;
	}
}
