package com.uca.capas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uca.capas.domain.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer>{
	
	@Query(value = "select c.s_nombres, c.s_apellidos, v.s_marca, v.s_modelo, v.f_compra " + 
			"from store.cliente c, store.vehiculo v " + 
			"where c.c_cliente = v.c_cliente " + 
			"and c.c_cliente = :ccliente", nativeQuery = true)
	public List<Object[]> findVehiculosCliente(@Param("ccliente") Integer ccliente);

}
