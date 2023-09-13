package com.care.root;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.config.TestClass;

@Controller
public class MailController {
	@Autowired MailService ms;
	@Autowired TestClass testClass;
	
	@GetMapping("send_mail")
	public void sendMail(HttpServletResponse res) 
									throws IOException {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		ms.send("choheewon@hanmail.net",
				"�׽�Ʈ ����(����)", "�ȳ��ϼ���");
		
		out.print("������ �����߽��ϴ� : "+ testClass.getName() );
	}
	@GetMapping("send_mail2")
	public void sendMail2(HttpServletResponse res) 
									throws IOException {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		ms.send2();
		
		out.print("������ �����߽��ϴ� : "+ testClass.getName() );
	}
	@GetMapping("auth")
	public String authForm() {
		return "auth";
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:auth";
	}
	@PostMapping("auth_check")
	public String authCheck(HttpSession session,
				@RequestParam String email) {
		String[] e = email.split("@");
		System.out.println(e[0]);
		System.out.println(e[1]);
		
		ms.send3(e[0], session, email);
		
		return "redirect:https://www."+e[1] ;
	}
	@GetMapping("check")
	public String check(@RequestParam String userId,
						@RequestParam String userKey,
						HttpSession session) {
		//asdf133241 = session("choheewon")
		String sessionKey = (String)session.getAttribute(userId);
		if(sessionKey.equals(userKey)) {
			session.setAttribute("userId", userId);
		}
		return "redirect:auth";
	}
}











