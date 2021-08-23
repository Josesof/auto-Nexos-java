package com.invetario.models.service;

import java.util.List;

import com.invetario.models.entity.Cargo;
import com.invetario.models.entity.Producto;


public interface IProductoService {

	public List<Producto> findAll();
	
	public boolean save (Producto producto);

	public Producto findOne(Long id);

	public boolean delete(Long id);

}
