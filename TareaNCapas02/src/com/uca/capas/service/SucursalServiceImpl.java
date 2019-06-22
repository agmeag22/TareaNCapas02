package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Sucursal;
import com.uca.capas.repositories.SucursalRepository;

@Service
public class SucursalServiceImpl implements SucursalService {
	
	@Autowired
	SucursalRepository SucursalRepository;

	public List<Sucursal> findAll() {
		// TODO Auto-generated method stub
		return SucursalRepository.findAll();
	}

	public Sucursal findOne(Integer sucursal) {
		// TODO Auto-generated method stub
		return SucursalRepository.findById(sucursal).get();
	}

	@Transactional
	public Sucursal save(Sucursal s) {
		// TODO Auto-generated method stub
		return SucursalRepository.save(s);
	}

	public long countAll() {
		// TODO Auto-generated method stub
		return SucursalRepository.count();
	}

	public List<Sucursal> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return SucursalRepository.findAll(sort);
	}
	
	@Transactional
	public void delete(Sucursal s) {
		SucursalRepository.delete(s);
	}

	public List<Sucursal> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return SucursalRepository.findAll(page).getContent();
	}
	
	

}
