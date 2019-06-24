package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.uca.capas.domain.Empleado;
import com.uca.capas.domain.Sucursal;

public interface SucursalService {

	public List<Sucursal> findAll();
	
	public List<Sucursal> findAll(Sort sort);
	
	public List<Sucursal> findAll(Pageable page);

	public Sucursal findOne(Integer Sucursal);
	
	public Sucursal save(Sucursal s);
	
	public long countAll();
	
	public void delete(Sucursal s);
	
	public void updateSucursal(int s_id,String s_name,String s_location,
			String s_open,String s_close,int s_tables,String s_manager) throws DataAccessException ;
	
	//public boolean updateSucursal(Sucursal su) throws DataAccessException;
	
	

}
