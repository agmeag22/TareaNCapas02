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
import org.springframework.data.domain.Sort;
@Controller //manda a llamar a los metodos
public class MainController {
	
	static Logger log = Logger.getLogger(MainController.class.getName());
	

	
	
	@Autowired
	private EmpleadoService empleadoServ;
	
	
	@Autowired
	private SucursalService sucursalServ;
	

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
	
	@RequestMapping(value="/eliminaruser")
	public ModelAndView deleteuser(@ModelAttribute(value="user") User user,@RequestParam(value="id_store")int code) {
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
	public ModelAndView editaruser(@ModelAttribute(value="user") User user) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user",user);
		mav.setViewName("editaruser");
		return mav;
	}
	
	@RequestMapping(value="/nuevousuario")
	public ModelAndView addu(@RequestParam(value="id_store") int idstore) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("usuario",idstore);
		mav.setViewName("nuevouser");
		return mav;
	}
	
	@RequestMapping(value="/adduser")
	public ModelAndView adduser(@ModelAttribute(value="user") User user,@RequestParam(value="id_store")int code) {
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
