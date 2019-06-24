package com.uca.capas.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Empleado;
import com.uca.capas.domain.Sucursal;
import com.uca.capas.domain.User;
import com.uca.capas.service.EmpleadoService;
import com.uca.capas.service.SucursalService;
import com.uca.capas.service.UserService;

@Controller
public class UserController {
	@Autowired
	private EmpleadoService empleadoServ;
	
	
	@Autowired
	private SucursalService sucursalServ;
	

	@Autowired
	private UserService userServ;
	
	static Logger log = Logger.getLogger(MainController.class.getName());
	
	@RequestMapping(value="/eliminaruser")
	public ModelAndView delete(@ModelAttribute(value="user") User user,@RequestParam(value="id_store")int code) {
		ModelAndView mav = new ModelAndView();
		List<User> us=null;
		List<Empleado> em=null;
		Sucursal su=null;
		try {
			userServ.delete(user);
			su=sucursalServ.findOne(code);
			em=empleadoServ.findBySucursal(code);
			us=userServ.findBySucursal(code);
		}catch (Exception e){
			log.info("Error:"+e.toString());	
		}
		mav.addObject("store",su);
		mav.addObject("usuario",us);
		mav.addObject("empleados",em);
		mav.setViewName("verperfil");
		return mav;
	}
	@RequestMapping(value="/editaruser")
	public ModelAndView editar(@ModelAttribute(value="user") User user) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user",user);
		mav.setViewName("editaruser");
		return mav;
	}
	
	@RequestMapping(value="/nuevousuario")
	public ModelAndView add(@RequestParam(value="id_store") int idstore) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("usuario",idstore);
		mav.setViewName("nuevouser");
		return mav;
	}
	
	@RequestMapping(value="/adduser")
	public ModelAndView addd(@ModelAttribute(value="user") User user,@RequestParam(value="id_store")int code) {
		ModelAndView mav = new ModelAndView();
		List<User> us=null;
		List<Empleado> em=null;
		Sucursal su=null;
		try {
			userServ.save(user);
			su=sucursalServ.findOne(code);
			em=empleadoServ.findBySucursal(code);
			us=userServ.findBySucursal(code);
		}catch (Exception e){
			log.info("Error:"+e.toString());	
		}
		mav.addObject("store",su);
		mav.addObject("usuario",us);
		mav.addObject("empleados",em);
		mav.setViewName("verperfil");
		return mav;
	}
}
