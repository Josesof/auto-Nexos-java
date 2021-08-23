package com.invetario.models.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.invetario.models.entity.Producto;
import com.invetario.models.entity.Usuario;
import com.invetario.models.service.CargoServiceImpl;
import com.invetario.models.service.ProductoServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductoController {
	
	@Autowired
	ProductoServiceImpl productoServiceImpl;

	@RequestMapping(value = "/listarProductos", method = RequestMethod.GET)
	public List<Producto> productos() {

		try {
			
		
			return productoServiceImpl.findAll();

		} catch (Exception e) {

			System.out.println(e);
			return null;
		}  

	}

	@RequestMapping(value = "/guardarProducto", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public boolean create(@RequestBody Producto newProducto) {

		try {

			productoServiceImpl.save(newProducto);
			return true;

		} catch (Exception e) {

			System.out.println(e);
			return false;
		}

	}

	@GetMapping("/verProducto/{id}")
	public Producto show(@PathVariable Long id) {
		return productoServiceImpl.findOne(id);
	}

	@PutMapping("/editarProducto/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean update(@RequestBody Producto producto, @PathVariable Long id) {

		try {

			Producto productoActual = productoServiceImpl.findOne(id);			
			productoActual.setNombreProducto(producto.getNombreProducto());
			productoActual.setCantidad(producto.getCantidad());
			productoActual.setUsuario(producto.getUsuario());			
			productoActual.setFechaIngreso(producto.getFechaIngreso());
			productoServiceImpl.save(productoActual);
			
			
			

			return true;

		} catch (Exception e) {

			System.out.println(e);
			return false;
		}

	}

	@DeleteMapping("/eliminarProducto/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean delet(@PathVariable Long id) {
		try {

			productoServiceImpl.delete(id);
			return true;
		} catch (Exception e) {

			System.out.println(e);
			return false;
		}
	}


}
