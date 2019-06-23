package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "table_store")
public class Sucursal {

	@Id
	@GeneratedValue(generator="table_store_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "table_store_seq", sequenceName = "table_store.table_store_seq")
	@Column(name = "id_store")
	private Integer id_store;
	
	@Column(name = "store_name")
	private String store_name;
	
	@Column(name = "store_location")
	private String store_location;
	
	@Column(name = "store_tables")
	private String store_tables;
	
	@Column(name = "store_manager")
	private String store_manager;
	
	@Column(name = "store_schedule_open")
	private String store_schedule_open;
	
	@Column(name = "store_schedule_close")
	private String store_schedule_close;
	
	
	/*@OneToMany(mappedBy = "sucursal", fetch = FetchType.LAZY)
	List<Empleado> empleados;

	@OneToMany(mappedBy = "usuarios", fetch = FetchType.LAZY)
	List<User> usuarios;
*/
	public Integer getId_store() {
		return id_store;
	}

	public void setId_store(Integer id_store) {
		this.id_store = id_store;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getStore_location() {
		return store_location;
	}

	public void setStore_location(String store_location) {
		this.store_location = store_location;
	}

	public String getStore_tables() {
		return store_tables;
	}

	public void setStore_tables(String store_tables) {
		this.store_tables = store_tables;
	}

	public String getStore_manager() {
		return store_manager;
	}

	public void setStore_manager(String store_manager) {
		this.store_manager = store_manager;
	}

	public String getStore_schedule_open() {
		return store_schedule_open;
	}

	public void setStore_schedule_open(String store_schedule_open) {
		this.store_schedule_open = store_schedule_open;
	}

	public String getStore_schedule_close() {
		return store_schedule_close;
	}

	public void setStore_schedule_close(String store_schedule_close) {
		this.store_schedule_close = store_schedule_close;
	}

	/*public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public List<User> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<User> usuarios) {
		this.usuarios = usuarios;
	}*/

	public Sucursal(Integer id_store, String store_name, String store_location, String store_tables,
			String store_manager, String store_schedule_open, String store_schedule_close) {
		//, List<Empleado> empleados,
		//List<User> usuarios
		super();
		this.id_store = id_store;
		this.store_name = store_name;
		this.store_location = store_location;
		this.store_tables = store_tables;
		this.store_manager = store_manager;
		this.store_schedule_open = store_schedule_open;
		this.store_schedule_close = store_schedule_close;
		//this.empleados = empleados;
		//this.usuarios = usuarios;
	}

	public Sucursal() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
}
