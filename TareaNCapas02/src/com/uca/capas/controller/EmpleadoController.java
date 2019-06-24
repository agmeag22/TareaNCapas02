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
public class EmpleadoController {

	static Logger log = Logger.getLogger(MainController.class.getName());
	
	@Autowired
	private EmpleadoService empleadoServ;
	
	
	@Autowired
	private SucursalService sucursalServ;
	

	@Autowired
	private UserService userServ;
	
	
	@RequestMapping(value="/eliminarempleado")
	public ModelAndView delete(@ModelAttribute(value="empleado") Empleado empleado,@RequestParam(value="id_store")int code) {
		ModelAndView mav = new ModelAndView();
		List<User> us=null;
		List<Empleado> em=null;
		Sucursal su=null;
		try {
			empleadoServ.delete(empleado);
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
	@RequestMapping(value="/editarempleado")
	public ModelAndView editar(@ModelAttribute(value="empleado") Empleado empleado) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("empleado",empleado);
		mav.setViewName("editarempleado");
		return mav;
	}
	
	@RequestMapping(value="/nuevoempleado",params = {"id_store"})
	public ModelAndView add(@RequestParam(value="id_store") int id_store) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("id_store",id_store);
		mav.setViewName("nuevoempleado");
		return mav;
	}
	
	@RequestMapping(value="/addempleado")
	public ModelAndView add(@ModelAttribute(value="empleado") Empleado empleado,@RequestParam(value="id_store")int code) {
		ModelAndView mav = new ModelAndView();
		List<User> us=null;
		List<Empleado> em=null;
		Sucursal su=null;
		try {
			empleadoServ.save(empleado);
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
