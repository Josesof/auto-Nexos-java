package com.invetario.models.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "cargos")
public class Cargo {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre_cargo")
	private String nombreCargo;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="cargo_id")
	private List<Usuario> usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCargo() {
		return nombreCargo;
	}

	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}


	


	
}
