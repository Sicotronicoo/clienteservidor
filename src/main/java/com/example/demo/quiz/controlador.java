package com.example.demo.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

@Controller
public class controlador {

@RequestMapping(value="/quiz", method=RequestMethod .GET)
  public String quiz_get() {
	
    return "quizindex";
  }
  
  @RequestMapping(value="/quiz", method=RequestMethod.POST)
  	public String quiz_post(){  	  
	  
	return "redirect:/quiz1";
  }
  @RequestMapping(value="/quiz1", method=RequestMethod.GET)
  public String quiz1_get() {
	  
			
    return "quiz1";
  }
  
  @RequestMapping(value="/quiz1", method=RequestMethod.POST)
  	public String quiz1_post(){   	  		
	  
	return "redirect:/quiz2";
  }
  @RequestMapping(value="/quiz2", method=RequestMethod.GET)
  public String quiz2_get() {
	
    return "quiz2";
  }
  
  @RequestMapping(value="/quiz2", method=RequestMethod.POST)
  	public String quiz2_post(){  	  
	  
	return "redirect:/quiz3";
  }
  @RequestMapping(value="/quiz3", method=RequestMethod.GET)
  public String quiz3_get() {
	
    return "quiz3";
  }
  
  @RequestMapping(value="/quiz3", method=RequestMethod.POST)
  	public String quiz3_post(){ 	  
	  
	return "redirect:/quiz4";
  }
  @RequestMapping(value="/quiz4", method=RequestMethod.GET)
  public String quiz4_get() {
	
    return "quiz4";
  }
  
  @RequestMapping(value="/quiz4", method=RequestMethod.POST)
  	public String quiz4_post(){  	  
	  
	return "redirect:/quiz5";
  }
  @RequestMapping(value="/quiz5", method=RequestMethod.GET)
  public String quiz5_get() {
	
    return "quiz5";
  }
  
  @RequestMapping(value="/quiz5", method=RequestMethod.POST)
  	public String quiz5_post(){  	  
	  
	return "redirect:/quiz6";
  }
  @RequestMapping(value="/quiz6", method=RequestMethod.GET)
  public String quiz6_get() {
	
    return "quiz6";
  }
  
  @RequestMapping(value="/quiz6", method=RequestMethod.POST)
  	public String quiz6_post(){  	  
	  
	return "redirect:/quiz7";
  }
  @RequestMapping(value="/quiz7", method=RequestMethod.GET)
  public String quiz7_get() {
	
    return "quiz7";
  }
  
  @RequestMapping(value="/quiz7", method=RequestMethod.POST)
  	public String quiz7_post(Model modelo, HttpSession session,
			@RequestParam String estreno,
			@RequestParam String droga,
			@RequestParam String temporada,
			@RequestParam String enfermedad,
			@RequestParam String nombreSecundario,
			@RequestParam String edad,
			@RequestParam String anio){  	  
	  
	  		modelo.addAttribute("estreno_form", estreno);
	  		modelo.addAttribute("droga_form", droga);
	  		modelo.addAttribute("temporada_form", temporada);
	  		modelo.addAttribute("enfermedad_form", enfermedad);
	  		modelo.addAttribute("nombreSecundario_form", nombreSecundario);
	  		modelo.addAttribute("edad_form", edad);
	  		modelo.addAttribute("anio_form", anio);
	return "resultado";
  }
}