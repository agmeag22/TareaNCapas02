package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller //manda a llamar a los metodos
public class MainController {
	
	static Logger log = Logger.getLogger(MainController.class.getName());
	
	@RequestMapping("/")
	public ModelAndView initMain() {
		log.info("Entrando a funcion init-min" + log.getName());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
}