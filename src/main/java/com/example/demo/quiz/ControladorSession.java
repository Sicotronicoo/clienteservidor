package com.example.demo.quiz;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorSession {
@GetMapping("/session")
public String process(Model model, HttpSession session) {
	@SuppressWarnings("unchecked")
	List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");
	if (messages == null) {
		messages = new ArrayList<>();
	}
	model.addAttribute("sessionMessages", messages);
	return "session";
	}
}

