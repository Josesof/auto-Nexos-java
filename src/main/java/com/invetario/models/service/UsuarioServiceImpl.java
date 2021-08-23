package com.invetario.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invetario.models.dao.IUsuarioDao;
import com.invetario.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	IUsuarioDao usuarioRepository;

	@Override
	public List<Usuario> findAll() {
		
		return (List<Usuario>) usuarioRepository.findAll();
	}
	


	@Override
	public Usuario findOne(Long id) {
	
		return usuarioRepository.findById(id).orElse(null);
	}




	@Override
	public boolean save(Usuario usuario) {
		usuarioRepository.save(usuario);
		return true;
	}



	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(id);
		return true;
	}
	
	

}
