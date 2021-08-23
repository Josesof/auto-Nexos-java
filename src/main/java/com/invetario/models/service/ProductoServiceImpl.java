package com.invetario.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invetario.models.dao.IProductoDao;
import com.invetario.models.entity.Producto;


@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	IProductoDao productoRepository;

	@Override
	public List<Producto> findAll() {
		
		return (List<Producto>) productoRepository.findAll();
	}

	@Override
	public boolean save(Producto producto) {
		
		productoRepository.save(producto);
		return true;
	}

	@Override
	public Producto findOne(Long id) {
		
		return productoRepository.findById(id).orElse(null);
		
	}

	@Override
	public boolean delete(Long id) {
		
		productoRepository.deleteById(id);
		return true;
		
	}

	

}
