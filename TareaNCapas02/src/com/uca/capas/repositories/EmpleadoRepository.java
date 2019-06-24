package com.uca.capas.repositories;

import java.util.List;



import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uca.capas.domain.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{

	public List<Empleado> findAll(Sort sort);
	
	//El metodo recibe un objeto de tipo Pageable, sin embargo al ser llamado es un new PageRequest lo que se le envia
	public Page<Empleado> findAll(Pageable page);
	
	@Query(nativeQuery=true,value="select * from table_employe e where e.id_store= :code")
	public List<Empleado> findBySucursal(@Param("code")int code) throws DataAccessException ;
}
