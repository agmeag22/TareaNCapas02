package com.uca.capas.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Empleado;
import com.uca.capas.domain.Sucursal;
import com.uca.capas.repositories.SucursalRepository;

@Service
public class SucursalServiceImpl implements SucursalService {
	
	@Autowired
	SucursalRepository sucursalRepository;

	public List<Sucursal> findAll() {
		// TODO Auto-generated method stub
		return sucursalRepository.findAll();
	}

	public Sucursal findOne(Integer sucursal) {
		// TODO Auto-generated method stub
		return sucursalRepository.findById(sucursal).get();
	}

	@Transactional
	public Sucursal save(Sucursal s) {
		// TODO Auto-generated method stub
		return sucursalRepository.save(s);
	}

	public long countAll() {
		// TODO Auto-generated method stub
		return sucursalRepository.count();
	}

	public List<Sucursal> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return sucursalRepository.findAll(sort);
	}
	
	@Transactional
	public void delete(Sucursal s) {
		sucursalRepository.delete(s);
	}

	public List<Sucursal> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return sucursalRepository.findAll(page).getContent();
	}

	@Transactional
	public void updateSucursal(int s_id,String s_name,String s_location,
			String s_open,String s_close,int s_tables,String s_manager) throws DataAccessException {
		sucursalRepository.updateSucursal(s_id, s_name, s_location, s_open, s_close, s_tables, s_manager);
		// TODO Auto-generated method stub
	}
	/*@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Transactional
	public boolean updateSucursal(Sucursal su) throws DataAccessException{
	try {
			entityManager.persist(su);
			return true;
		}catch(Throwable e) {
			return false;
		}
	}*/
	
	

}
