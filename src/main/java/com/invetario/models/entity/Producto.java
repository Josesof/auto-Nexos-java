package com.invetario.models.entity;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "productos")
public class Producto  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombreProducto;	
	private int cantidad;
	
	@Column(name = "fecha_ingreso")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaIngreso;	
	
	@Column(name = "fecha_modifico")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaModifica;
	
	@PrePersist
	public void prePersist() {
		fechaModifica = new Date();
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id", insertable = false, updatable = false)  
	private Usuario usuario;
	

	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaModifica() {
		return fechaModifica;
	}

	public void setFechaModifica(Date fechaModifica) {
		this.fechaModifica = fechaModifica;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombreProducto=" + nombreProducto + ", cantidad=" + cantidad
				+ ", fechaIngreso=" + fechaIngreso + ", fechaModifica=" + fechaModifica + "]";
	}
	
	
	
		

}
