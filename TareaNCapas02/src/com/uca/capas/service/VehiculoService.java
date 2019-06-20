package com.uca.capas.service;

import java.text.ParseException;
import java.util.List;

import com.uca.capas.domain.Vehiculo;
import com.uca.capas.dto.AsociarDTO;
import com.uca.capas.dto.VehiculosDTO;

public interface VehiculoService {
	
	public List<Vehiculo> findAll();
	
	public Vehiculo findOne(Integer codigo);
	
	public List<VehiculosDTO> findVehiculosCliente(Integer cliente);
	
	public Vehiculo save(AsociarDTO dto) throws ParseException;


}
