package org.techshare.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestProc {

	@RequestMapping(value="/")
	public String index() {
		return "index.html";
	}
}
