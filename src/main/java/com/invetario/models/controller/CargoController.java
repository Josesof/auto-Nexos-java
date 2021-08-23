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

import com.invetario.models.entity.Cargo;
import com.invetario.models.service.CargoServiceImpl;

@RestController
@RequestMapping("/api")
public class CargoController {

	@Autowired
	CargoServiceImpl cargoServiceImpl;

	@RequestMapping(value = "/listarCargos", method = RequestMethod.GET)
	public List<Cargo> cargos() {

		try {

			return cargoServiceImpl.findAll();

		} catch (Exception e) {

			System.out.println(e);
			return null;
		}

	}

	@RequestMapping(value = "/guardarCargo", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public boolean create(@RequestBody Cargo newCargo) {

		try {

			cargoServiceImpl.save(newCargo);
			return true;

		} catch (Exception e) {

			System.out.println(e);
			return false;
		}

	}

	@GetMapping("/ver/{id}")
	public Cargo show(@PathVariable Long id) {
		return cargoServiceImpl.findOne(id);
	}

	
	@RequestMapping(value = "/editarCargo/{id}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public boolean update(@RequestBody Cargo cargo, @PathVariable Long id) {

		try {

			Cargo cargoActual = cargoServiceImpl.findOne(id);			
			cargoActual.setNombreCargo(cargo.getNombreCargo());
			cargoServiceImpl.save(cargoActual);
			return true;

		} catch (Exception e) {

			System.out.println(e);
			return false;
		}

	}

	@DeleteMapping("/eliminarCargo/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean delet(@PathVariable Long id) {
		try {

			cargoServiceImpl.delete(id);
			return true;
		} catch (Exception e) {

			System.out.println(e);
			return false;
		}
	}

}
