package com.invetario.models.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invetario.models.dao.ICargoDao;
import com.invetario.models.entity.Cargo;


@Service
public class CargoServiceImpl implements ICargoService {
	
	@Autowired
	ICargoDao cargoRepository;

	@Override
	public List<Cargo> findAll() {
		
		return (List<Cargo>) cargoRepository.findAll();
	}

	@Override
	public boolean save(Cargo cargo) {		
		
		cargoRepository.save(cargo);
		return true;
		
	}

	@Override
	public Cargo findOne(Long id) {
		
		return cargoRepository.findById(id).orElse(null);
	}

	@Override
	public boolean delete(Long id) {
		
		cargoRepository.deleteById(id);
		return true;
		
	}


}
