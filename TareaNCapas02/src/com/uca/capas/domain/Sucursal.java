package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name = "store_schedule")
	private String store_schedule;
	
	@Column(name = "store_tables")
	private String store_tables;
	
	@Column(name = "store_manager")
	private String store_manager;

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

	public String getStore_schedule() {
		return store_schedule;
	}

	public void setStore_schedule(String store_schedule) {
		this.store_schedule = store_schedule;
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
	
	
}
