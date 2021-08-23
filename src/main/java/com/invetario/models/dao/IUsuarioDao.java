package com.invetario.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.invetario.models.entity.Usuario;



public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

}
