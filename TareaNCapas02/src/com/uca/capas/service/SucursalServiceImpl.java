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
import com.uca.capas.repositories.EmpleadoRepository;
import com.uca.capas.repositories.SucursalRepository;

@Service
public class SucursalServiceImpl implements SucursalService {
	
	@Autowired
	SucursalRepository sucursalRepository;
	
	@Autowired
	EmpleadoRepository empleadoRepository;

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


	@Transactional
	public void delete(Sucursal s) {
		sucursalRepository.delete(s);
	}

	public List<Sucursal> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return sucursalRepository.findAll(page).getContent();
	}

	
}
