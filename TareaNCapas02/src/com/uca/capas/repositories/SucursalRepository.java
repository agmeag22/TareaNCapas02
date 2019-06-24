package com.uca.capas.repositories;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uca.capas.domain.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Integer>{

	public List<Sucursal> findAll(Sort sort);
	
	//El metodo recibe un objeto de tipo Pageable, sin embargo al ser llamado es un new PageRequest lo que se le envia
	public Page<Sucursal> findAll(Pageable page);
	
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery=true, value="UPDATE table_store\r\n" + 
			"	SET store_name =:s_name,\r\n" + 
			"	store_location =:s_location,\r\n" + 
			"	store_tables = :s_tables, \r\n" + 
			"	store_manager = :s_manager,\r\n" + 
			"	store_schedule_open= :s_open, \r\n" + 
			"	store_schedule_close= :s_close\r\n" + 
			"	WHERE id_store=:s_id")
	public void updateSucursal(@Param("s_id") int s_id,@Param("s_name") String s_name,@Param("s_location") String s_location,
			@Param("s_open") String s_open,@Param("s_close") String s_close,@Param("s_tables") int s_tables,@Param("s_manager") String s_manager) throws DataAccessException ;
	
}