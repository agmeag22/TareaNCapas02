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
@Table(schema = "public", name = "table_employe")
public class Empleado {

	@Id
	@GeneratedValue(generator="table_employee_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "table_employee_seq", sequenceName = "table_employe.table_employee_seq",allocationSize=1)
	@Column(name = "id_empleado")
	private Integer id_empleado;
	
	@Column(name = "e_name")
	private String e_name;
	
	@Column(name = "e_age")
	private String e_age;
	
	@Column(name = "e_gender")
	private String e_gender;
	
	@Column(name="id_store")
	private int id_store;
	
	@Column(name="active_state")
	private int active_state;
	
	/*@ManyToOne( fetch = FetchType.LAZY)
	private Sucursal sucursal;*/

	public Integer getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Integer id_empleado) {
		this.id_empleado = id_empleado;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public String getE_age() {
		return e_age;
	}

	public void setE_age(String e_age) {
		this.e_age = e_age;
	}

	public String getE_gender() {
		return e_gender;
	}

	public void setE_gender(String e_gender) {
		this.e_gender = e_gender;
	}

	public int getId_store() {
		return id_store;
	}

	public void setId_store(int id_store) {
		this.id_store = id_store;
	}

	public int getActive_state() {
		return active_state;
	}

	public void setActive_state(int active_state) {
		this.active_state = active_state;
	}

	/*public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}*/

	public Empleado(Integer id_empleado, String e_name, String e_age, String e_gender, int id_store, int active_state) {
		//,Sucursal sucursal
		super();
		this.id_empleado = id_empleado;
		this.e_name = e_name;
		this.e_age = e_age;
		this.e_gender = e_gender;
		this.id_store = id_store;
		this.active_state = active_state;
		//this.sucursal = sucursal;
	}

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	
		
}
