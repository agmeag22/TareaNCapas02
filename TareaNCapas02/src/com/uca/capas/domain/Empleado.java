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
@Table(schema = "public", name = "table_employee")
public class Empleado {

	@Id
	@GeneratedValue(generator="table_employee_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "table_employee_seq", sequenceName = "table_employee.table_employee_seq")
	@Column(name = "id_employee")
	private Integer id_employee;
	
	@Column(name = "employee_name")
	private String employee_name;
	
	@Column(name = "employee_age")
	private String employee_age;
	
	@Column(name = "employee_gender")
	private String employee_gender;
	
	@Column(name="id_store")
	private Integer id_store;
	
	@Column(name="active_state")
	private Integer active_state;
	
	@ManyToOne( fetch = FetchType.LAZY)
	private Sucursal sucursal;

	public Integer getId_employee() {
		return id_employee;
	}

	public void setId_employee(Integer id_employee) {
		this.id_employee = id_employee;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_age() {
		return employee_age;
	}

	public void setEmployee_age(String employee_age) {
		this.employee_age = employee_age;
	}

	public String getEmployee_gender() {
		return employee_gender;
	}

	public void setEmployee_gender(String employee_gender) {
		this.employee_gender = employee_gender;
	}

	public Integer getId_store() {
		return id_store;
	}

	public void setId_store(Integer id_store) {
		this.id_store = id_store;
	}

	public Integer getActive_state() {
		return active_state;
	}

	public void setActive_state(Integer active_state) {
		this.active_state = active_state;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Empleado(Integer id_employee, String employee_name, String employee_age, String employee_gender,
			Integer id_store, Integer active_state, Sucursal sucursal) {
		super();
		this.id_employee = id_employee;
		this.employee_name = employee_name;
		this.employee_age = employee_age;
		this.employee_gender = employee_gender;
		this.id_store = id_store;
		this.active_state = active_state;
		this.sucursal = sucursal;
	}

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

		
}
