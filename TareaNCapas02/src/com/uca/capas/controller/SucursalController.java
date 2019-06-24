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
public class SucursalController {

	@Autowired
	private EmpleadoService empleadoServ;
	
	
	@Autowired
	private SucursalService sucursalServ;
	

	@Autowired
	private UserService userServ;
	
	static Logger log = Logger.getLogger(MainController.class.getName());
	
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
	@RequestMapping(value="/registrar")
	public ModelAndView registrar() {
		ModelAndView mav = new ModelAndView();
		List<Empleado> empleados=null;
		try {
			empleados=empleadoServ.findAll( );
		}catch(Exception e){
		}
		mav.addObject("empleados",empleados);
		mav.setViewName("registrarsucursal");
		return mav;
	}
	
	@RequestMapping(value="/guardar")
	public ModelAndView save(@ModelAttribute(name="sucursal") Sucursal sucursal) {
		ModelAndView mav = new ModelAndView();
		List<Sucursal> sucursales = null;
		try {
			sucursalServ.save(sucursal);
			sucursales = sucursalServ.findAll();
		}catch (Exception e){
			log.info("Error:"+e.toString());	
		}
		mav.addObject("store",sucursales);
		mav.setViewName("listasucursales");
		return mav;
	}
	@RequestMapping(value="/eliminar")
	public ModelAndView delete(@RequestParam(value="code") int code) {
		ModelAndView mav = new ModelAndView();
		List<Sucursal> sucursales = null;
		String message="";
		
		try {
			sucursalServ.delete(sucursalServ.findOne(code));
			sucursales = sucursalServ.findAll( );
			message="Se ha borrado con exito";
		}catch (Exception e){
			log.info("Error:"+e.toString());	
		}
		mav.addObject("store",sucursales);
		mav.addObject("message",message);
		mav.setViewName("listasucursales");
		return mav;
	}
	
	@RequestMapping(value="/editar")
	public ModelAndView edit(@RequestParam(value="code") int code) {
		ModelAndView mav = new ModelAndView();
		Sucursal sucursal = null;
		List <Empleado> empleados=null;
		try {
			sucursal=sucursalServ.findOne(code);
			empleados=empleadoServ.findBySucursal(code);
		}catch (Exception e){
			log.info("Error:"+e.toString());	
		}
		mav.addObject("empleados",empleados);
		mav.addObject("store",sucursal);
		mav.setViewName("editarperfil");
		return mav;
	}
	
	@RequestMapping(value="/actualizar")
	public ModelAndView actualizar(@ModelAttribute(value="sucursal") Sucursal su) {
		ModelAndView mav = new ModelAndView();
		Sucursal sucursal=su;
		List <Sucursal> sucursales=null;
		String message="";
		try {
				
			sucursalServ.save(sucursal);
			message="actualizacion con exito";
			sucursales=sucursalServ.findAll( );
		}catch (Exception e){
			log.info("Error:"+e.toString());	
		}
		mav.addObject("store",sucursales);
		mav.addObject("message",message);
		mav.setViewName("listasucursales");
		return mav;
	}
}
