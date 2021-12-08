package com.idat.Controller;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.Entity.Producto;
import com.idat.Service.ProductoService;

@RestController
@RequestMapping("/v1")
public class ProductoController {

	@Autowired
	@Qualifier("productoServiceImpl")
	private ProductoService productoService;	
	
	@GetMapping("/listar")
	public ResponseEntity<?> listado()
	{
		return new ResponseEntity<>(productoService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/Buscar/{productoId}")
	public ResponseEntity<?> BuscarId(@PathVariable int productoId)
	{
		Producto producto=productoService.findById(productoId);
		if(producto != null) {
			return new ResponseEntity<>(producto,HttpStatus.OK);
		}
	
		return new ResponseEntity<>("NOSE ENCONTRO EL PRODUCTO",HttpStatus.OK);
	}
	
	@PostMapping("/resgistrar")
	public ResponseEntity<?> RegistarProducto(@RequestBody Producto p) 
	{	
		productoService.insert(p);	
		return new ResponseEntity<>("SE INSERTO CORRECTAMENTE" , HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> ActualizarProducto(@RequestBody Producto producto,@PathVariable int id) 
	{
		Producto productos=productoService.findById(id);
		
		if(productos != null) 
		{
			productos.setNombre(producto.getNombre());
			productos.setMarca(producto.getMarca());
			productos.setPrecio(producto.getPrecio());
			productos.setFvencimiento(producto.getFvencimiento());
			productos.setStock(producto.getStock());
			
			productoService.update(productos);
			
			return new ResponseEntity<>("SE ACTULIZO CORRECTAMENTE CORRECTAMENTE" , HttpStatus.OK);		
		}
		return new ResponseEntity<>("NO se actualzi" , HttpStatus.OK);
	}
	
	@DeleteMapping("/Eliminar/{id}")
	public ResponseEntity<?> EliminarProducto(@PathVariable int id) 
	{
		Producto productos=productoService.findById(id);	
		if(productos != null) 
		{
			productoService.delete(id);
			//return new ResponseEntity<>("SE ELIMINO CORRECTAMENTE" , HttpStatus.NOT FOUND);
			return new ResponseEntity<>("SE ELIMINO CORRECTAMENTE" , HttpStatus.OK);	
		}
		return new ResponseEntity<>("NO SE ELIMINO CORRECTAMENTE" , HttpStatus.OK);
	}
}