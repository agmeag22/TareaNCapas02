package com.uca.capas.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Cliente;
import com.uca.capas.domain.Vehiculo;
import com.uca.capas.dto.AsociarDTO;
import com.uca.capas.dto.VehiculosDTO;
import com.uca.capas.repositories.VehiculoRepository;

@Service
public class VehiculoServiceImpl implements VehiculoService {

	@Autowired
	VehiculoRepository vehiculoRepository;
	
	@Autowired
	UserService clienteService;

	public List<Vehiculo> findAll() {
		// TODO Auto-generated method stub
		return vehiculoRepository.findAll();
	}

	public Vehiculo findOne(Integer codigo) {
		// TODO Auto-generated method stub
		return vehiculoRepository.findById(codigo).get();
	}

	public List<VehiculosDTO> findVehiculosCliente(Integer cliente) {
		// TODO Auto-generated method stub

		//Convierto lista de objetos a lista de el DTO correspondiente utilizando
		//la funcion map del API Stream (Java 8)
		List<VehiculosDTO> vehiculos = vehiculoRepository.findVehiculosCliente(cliente)
				.stream()
				.map(obj -> {
					VehiculosDTO v = new VehiculosDTO();
					v.setNombre(obj[0].toString());
					v.setApellido(obj[1].toString());
					v.setMarca(obj[2].toString());
					v.setModelo(obj[3].toString());
					v.setFechaCompra(obj[4].toString());
					return v;
				}).collect(Collectors.toList());

		return vehiculos;
	}

	@Transactional
	public Vehiculo save(AsociarDTO dto) throws ParseException {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		cal.setTime(sdf.parse(dto.getFcompra()));
		
		Cliente c = clienteService.findOne(dto.getCliente());
		
		//Creo un nuevo vehiculo
		Vehiculo v = new Vehiculo();
		v.setSmarca(dto.getSmarca());
		v.setSmodelo(dto.getSmodelo());
		v.setSchassis(dto.getSchassis());
		v.setFcompra(cal);
		v.setBestado(dto.getBestado());
		v.setCliente(c);
		return vehiculoRepository.save(v);
	}


}
