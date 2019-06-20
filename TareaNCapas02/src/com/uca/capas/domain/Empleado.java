package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@OneToMany(mappedBy = "table_store", fetch = FetchType.LAZY)
	private List<Sucursal> sucursales;

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

	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}
	
	
}
