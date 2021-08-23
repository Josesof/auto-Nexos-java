package com.invetario.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;





@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;	
	private int edad;
	
	
	
	@Column(name = "fecha_ingreso")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaIngresoCompania;





	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public Date getFechaIngresoCompania() {
		return fechaIngresoCompania;
	}


	public void setFechaIngresoCompania(Date fechaIngresoCompania) {
		this.fechaIngresoCompania = fechaIngresoCompania;
	}






	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
}
