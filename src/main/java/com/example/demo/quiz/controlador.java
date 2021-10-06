package com.example.demo.quiz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controlador {
	int puntuacion;

	@PostMapping("/destroy")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/session";
	}

	@RequestMapping(value = "/quiz", method = RequestMethod.GET)
	public String quiz_get() {

		return "quizindex";
	}


	@RequestMapping(value = "/quiz1", method = RequestMethod.GET)
	public String quiz1_get() {

		return "quiz1";
	}

	@RequestMapping(value = "/quiz1", method = RequestMethod.POST)
	public String quiz1_post(HttpSession httpSession, @RequestParam String anioLanzamiento) {

		httpSession.setAttribute("pregunta1", anioLanzamiento);
		return "redirect:/quiz2";
	}

	@RequestMapping(value = "/quiz2", method = RequestMethod.GET)
	public String quiz2_get() {

		return "quiz2";
	}

	@RequestMapping(value = "/quiz2", method = RequestMethod.POST)
	public String quiz2_post(HttpSession httpSession, @RequestParam String droga) {

		httpSession.setAttribute("pregunta2", droga);
		return "redirect:/quiz3";
	}

	@RequestMapping(value = "/quiz3", method = RequestMethod.GET)
	public String quiz3_get() {

		return "quiz3";
	}

	@RequestMapping(value = "/quiz3", method = RequestMethod.POST)
	public String quiz3_post(HttpSession httpSession, @RequestParam String temporada) {

		httpSession.setAttribute("pregunta3", temporada);
		return "redirect:/quiz4";
	}

	@RequestMapping(value = "/quiz4", method = RequestMethod.GET)
	public String quiz4_get() {

		return "quiz4";
	}

	@RequestMapping(value = "/quiz4", method = RequestMethod.POST)
	public String quiz4_post(HttpSession httpSession, @RequestParam String enfermedad) {

		httpSession.setAttribute("pregunta4", enfermedad);
		return "redirect:/quiz5";
	}

	@RequestMapping(value = "/quiz5", method = RequestMethod.GET)
	public String quiz5_get() {

		return "quiz5";
	}

	@RequestMapping(value = "/quiz5", method = RequestMethod.POST)
	public String quiz5_post(HttpSession httpSession, @RequestParam String nombreSecundario) {

		httpSession.setAttribute("pregunta5", nombreSecundario);
		return "redirect:/quiz6";
	}

	@RequestMapping(value = "/quiz6", method = RequestMethod.GET)
	public String quiz6_get() {

		return "quiz6";
	}

	@RequestMapping(value = "/quiz6", method = RequestMethod.POST)
	public String quiz6_post(HttpSession httpSession, @RequestParam String anio) {

		httpSession.setAttribute("pregunta7", anio);
		return "redirect:/quiz7";
	}

	@RequestMapping(value = "/quiz7", method = RequestMethod.GET)
	public String quiz7_get() {

		return "quiz7";
	}

	@RequestMapping(value = "/quiz7", method = RequestMethod.POST)
	public String quiz7_post(HttpSession httpSession) {
		
		String anioLanzamiento = (String) httpSession.getAttribute("pregunta1");
		return "redirect:/resultado";
	}
}