package com.invetario.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.invetario.models.entity.Cargo;



public interface ICargoDao  extends CrudRepository<Cargo, Long>{

}
