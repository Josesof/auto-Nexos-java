package com.invetario.models.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.invetario.models.entity.Usuario;

import com.invetario.models.service.UsuarioServiceImpl;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;

	@RequestMapping(value = "/listarUsuarios", method = RequestMethod.GET)
	public List<Usuario> usuarios() {

		try {

			return usuarioServiceImpl.findAll();

		} catch (Exception e) {

			System.out.println(e);
			return null;
		}

	}

	@RequestMapping(value = "/guardarUsuario", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public boolean create(@RequestBody Usuario newUsuario) {

		try {

			usuarioServiceImpl.save(newUsuario);
			return true;

		} catch (Exception e) {

			System.out.println(e);
			return false;
		}

	}

	@GetMapping("/verUsuario/{id}")
	public Usuario show(@PathVariable Long id) {
		return usuarioServiceImpl.findOne(id);
	}


	@RequestMapping(value = "/editarUsuario/{id}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public boolean update(@RequestBody Usuario usuario, @PathVariable Long id) {

		try {

			Usuario usuarioActual = usuarioServiceImpl.findOne(id);
			
			usuarioActual.setNombre(usuario.getNombre());
			usuarioActual.setEdad(usuario.getEdad());
			usuarioActual.setFechaIngresoCompania(usuario.getFechaIngresoCompania());
			usuarioServiceImpl.save(usuarioActual);
			return true;

		} catch (Exception e) {

			System.out.println(e);
			return false;
		}

	}

	@DeleteMapping("/eliminarUsuario/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean delet(@PathVariable Long id) {
		try {

			usuarioServiceImpl.delete(id);
			return true;
		} catch (Exception e) {

			System.out.println(e);
			return false;
		}
	}

}
