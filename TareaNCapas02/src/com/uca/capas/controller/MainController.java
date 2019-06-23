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

import com.uca.capas.domain.Empleado;
import com.uca.capas.domain.User;
import com.uca.capas.domain.Sucursal;
import com.uca.capas.repositories.EmpleadoRepository;
import com.uca.capas.repositories.SucursalRepository;
import com.uca.capas.repositories.UserRepository;
import com.uca.capas.service.EmpleadoService;
import com.uca.capas.service.SucursalService;
import com.uca.capas.service.UserService;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller //manda a llamar a los metodos
public class MainController {
	
	static Logger log = Logger.getLogger(MainController.class.getName());
	

	
	@Autowired
	private EmpleadoRepository empleadoRepo;
	
	@Autowired
	private EmpleadoService empleadoServ;
	
	@Autowired
	private SucursalRepository sucursalRepo;
	
	@Autowired
	private SucursalService sucursalServ;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserService userServ;
	
	@RequestMapping("/")
	public ModelAndView initMain() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(@RequestParam(value="username") String username,@RequestParam(value="password") String password) {
		ModelAndView mav = new ModelAndView();
		if(userServ.findOneUser(username, password)) {
			log.info("Entrando a funcion init-min" + log.getName());
			mav.setViewName("main");
		}else {
			mav.setViewName("login");
		}
			log.info("No se pudo realizar" + log.getName() +"u:::::::"+ username+ "p::::::"+password);
		return mav; 
	}
	
	@RequestMapping(value="/mostrar")
	public ModelAndView mostrar(@ModelAttribute Sucursal sucursal) {
		ModelAndView mav = new ModelAndView();
		List<Sucursal> sucursales = null;
		try {
			sucursales = sucursalServ.findAll();
		}catch(Exception e){
			log.info("Error:"+e.toString());
		}
		mav.addObject("store",sucursales);
		mav.setViewName("listasucursales");
		return mav;
	}
	
	@RequestMapping(value="/verperfil")
	public ModelAndView perfil(@RequestParam(value="code") int code) {
		ModelAndView mav = new ModelAndView();
		Sucursal sucursal = null;
		List<Empleado> empleados=null;
		List <User> usuarios=null;
		
		try {
			sucursal = sucursalServ.findOne(code);
			empleados=empleadoServ.findBySucursal(code);
			usuarios=userServ.findBySucursal(code);
			
			
		}catch(Exception e){
			log.info("Error:"+e.toString());
		}
		mav.addObject("store",sucursal);
		mav.addObject("usuario",usuarios);
		mav.addObject("empleados",empleados);
		mav.setViewName("verperfil");
		return mav;
	}
	
}
