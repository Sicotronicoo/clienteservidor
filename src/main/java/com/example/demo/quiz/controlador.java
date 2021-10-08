package com.example.demo.quiz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controlador {

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
	public String quiz1_get(HttpSession httpSession) {
		httpSession.invalidate();
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
	public String quiz6_post(HttpSession httpSession, @RequestParam String edad) {

		httpSession.setAttribute("pregunta6", edad);
		return "redirect:/quiz7";
	}

	@RequestMapping(value = "/quiz7", method = RequestMethod.GET)
	public String quiz7_get() {

		return "quiz7";
	}
	@RequestMapping(value = "/quiz7", method = RequestMethod.POST)
	public String quiz7_post(HttpSession httpSession, @RequestParam String anio) {

		httpSession.setAttribute("pregunta7", anio);
		return "redirect:/resultado";
	}
	
	@RequestMapping(value = "/resultado", method = RequestMethod.GET)
	public String resultado_get(Model modelo,HttpSession httpSession) {
		int puntuacion = 0;
		String resultado ="";
		
		String anioLanzamiento = (String) httpSession.getAttribute("pregunta1");
		if(anioLanzamiento.equals("anio1")) {
			puntuacion++;
		}
		else {
			puntuacion = 0;
		}
		String drogas = (String) httpSession.getAttribute("pregunta2");
		if(drogas.equals("Metanfetamina")) {
			puntuacion++;
		}
		else {
			puntuacion = puntuacion + 0;
		}
		String temporada = (String) httpSession.getAttribute("pregunta3");
		if (temporada.equals("temp1")) {
			puntuacion++;
		}
		else if (temporada.equals("temp2")) {
			puntuacion=+2;
		}
		else if (temporada.equals("temp3")) {
			puntuacion=-1;
		}
		else if (temporada.equals("temp4")) {
			puntuacion=+3;
		}
		else {
			puntuacion=-2;
		}
		String enfermedad = (String) httpSession.getAttribute("pregunta4");
		if(enfermedad.equals("cancer")){
			puntuacion++;
		}
		else {
			puntuacion = puntuacion + 0;
		}
		String nombreSecundario = (String) httpSession.getAttribute("pregunta5");
		if(nombreSecundario.equals("jesse")){
			puntuacion++;
		}
		else {
			puntuacion = puntuacion + 0;
		}
		String edad = (String) httpSession.getAttribute("pregunta6");
		if(edad.equals("50")){
			puntuacion++;
		}
		else {
			puntuacion = puntuacion + 0;
		}
		String anio = (String) httpSession.getAttribute("pregunta7");
		if(anio.equals("2008-2013")){
			puntuacion++;
		}
		else {
			puntuacion = puntuacion + 0;
		}
		if (puntuacion <= 0) {
			resultado = "Das pena vuelve a ver la serie";
		}
		else if (puntuacion >=1 && puntuacion <= 3) {
			resultado = "Parece que tienes lagunas, deberias repasar la serie";
		}
		else if (puntuacion >=4 && puntuacion <=6) {
			resultado = "Se nota que te gusto la serie, enhorabuena";
		}
		else {
			resultado = "Heisenberg esta orgulloso de ti";
		}
		modelo.addAttribute("puntuacion_form", puntuacion);
		modelo.addAttribute("resultado_form", resultado);
		
		
		return "resultado";
	}
}