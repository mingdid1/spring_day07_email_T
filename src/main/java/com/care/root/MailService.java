package com.care.root;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired JavaMailSender mailSender;
	
	public void send(String to, 
						String subject,String body) {
		MimeMessage msg = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = 
				new MimeMessageHelper(msg, true,"utf-8");
			helper.setTo( to );
			helper.setSubject( subject );
			helper.setText( body );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		mailSender.send( msg );
	}
	public void send2() {
		String to = "choheewon@hanmail.net";
		String subject = "광고";
		
		StringBuffer sb = new StringBuffer();
		sb.append("<h1>제품소개</h1>");
		sb.append("<b>아무 내용이나</b>");
		
		sb.append("<a href='https://www.naver.com/'>네이버</a>");
		sb.append("<img src='data:image/png;base64,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'>");
		String body = sb.toString();
		
		
		MimeMessage msg = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = 
				new MimeMessageHelper(msg, true,"utf-8");
			helper.setTo( to );
			helper.setSubject( subject );
			helper.setText( body , true );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		mailSender.send( msg );
	}
	public void send3(String userId,
							HttpSession session,String email) {
		String userKey = rand();
		// session("choheewon","asdf1o334)
		session.setAttribute(userId, userKey);
		
		String body ="<h2>인증 해주세요</h2>"
		+ "<a href='http://localhost:8085/root/check?userId="
		+userId+"&userKey="+userKey+"'>인증하기</a>";
		
		MimeMessage msg = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = 
				new MimeMessageHelper(msg, true,"utf-8");
			helper.setTo( email );
			helper.setSubject( "인증해 주세요" );
			helper.setText( body , true );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		mailSender.send( msg );
		
	}
	private String rand() {
		Random ran = new Random();
		String str = "";
		while( str.length() <= 20 ) {
			int num = ran.nextInt(75) + 48;
			if((num >= 48 && num <= 57) ||
					(num >= 65 && num <= 90) || 
					(num >= 97 && num <= 122) ) {
				str += (char)num;
			}
		}
		return str;
	}
}












