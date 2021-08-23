package com.invetario.models.service;

import java.util.List;

import com.invetario.models.entity.Cargo;

public interface ICargoService {
	
	public List<Cargo> findAll();
	
	public boolean save (Cargo cargo);
	
	public Cargo findOne(Long id);
	
	public boolean delete(Long id);

}
