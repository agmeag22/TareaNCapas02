package com.uca.capas.domain;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema = "public", name = "table_user")
public class User {
	@Id
	@GeneratedValue(generator="user_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "user_seq", sequenceName = "public.user_seq",allocationSize=1)
	@Column(name = "id_user")
	private Integer iduser;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "pass")
	private String password;
	
	@Column(name = "id_store")
	private int id_store;
	
	/*@ManyToOne( fetch = FetchType.LAZY)
	private Sucursal usuarios;*/

	public Integer getIduser() {
		return iduser;
	}

	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	public int getId_store() {
		return id_store;
	}

	public void setId_store(int id_store) {
		this.id_store = id_store;
	}

	/*public Sucursal getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Sucursal usuarios) {
		this.usuarios = usuarios;
	}
*/

	public User(Integer iduser, String username, String password, int id_store) {
		//, Sucursal usuarios
		super();
		this.iduser = iduser;
		this.username = username;
		this.password = password;
		this.id_store = id_store;
		//this.usuarios = usuarios;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
