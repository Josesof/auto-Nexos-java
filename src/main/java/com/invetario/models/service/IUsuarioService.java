package com.invetario.models.service;

import java.util.List;

import com.invetario.models.entity.Usuario;


public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public boolean save (Usuario usuario);
	
	public Usuario findOne(Long id);
	
	public boolean delete(Long id);

}
