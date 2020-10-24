package com.example.security.springsecurity.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//問４－１ コントローラーを意味するアノテーションを記述
@Controller
//@Controller アノテーションを付けることで、DIコンテナにより、コントローラクラスが自動で読み込まれる。
public class AuthController {

	@Autowired
//	@Componentが宣言されたクラスのインスタンスを宣言する
	private AccountRepository repository;

	public List<Account> get() {
		return (List<Account>) repository.findAll();
	}

	@RequestMapping("/")
//	@Controller/@RequestControllerが遷移する先のURLを指定
	public String index() {
		return "redirect:/top";
	}

	@GetMapping("/login")
//	Getメソッドを受け付けるメソッドに記述
	public String login() {
		return "login";
	}

	@PostMapping("/login")
//	Postメソッドを受け付けるメソッドに記述
	public String loginPost() {
		return "redirect:/login-error";
	}

	@GetMapping("/login-error")
//	Getメソッドを受け付けるメソッドに記述
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	}

	@RequestMapping("/top")
//	@Controller/@RequestControllerが遷移する先のURLを指定
	public String top() {
		return "/top";
	}

}