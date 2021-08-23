package com.invetario.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.invetario.models.entity.Producto;



public interface IProductoDao  extends CrudRepository<Producto, Long>{

}
