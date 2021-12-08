package com.idat.Repositorio;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.idat.Entity.Producto;

@Repository("productoRepositoryImpl")
public class ProductoRepositoryImpl implements ProductoRepository {
	
	private static Map<Integer, Producto> repositorylista= new HashMap<>();
	static 
	{
		Producto producto1= new Producto(1, "Chocolate", "Donofrofio", 12.0, LocalDate.of(2022, 2, 1), 200);
		Producto producto2= new Producto(2, "Bombones", "Arcoir", 14.0, LocalDate.of(2022, 1, 14), 120);
		Producto producto3= new Producto(3, "Vino", "Rose", 24.0, LocalDate.of(2022, 2, 4), 850);
		Producto producto4= new Producto(4, "Paneton", "Sayon", 15.0, LocalDate.of(2022, 5, 12), 800);
		
		repositorylista.put(producto1.getProductoId(), producto1);
		repositorylista.put(producto2.getProductoId(), producto2);
		repositorylista.put(producto3.getProductoId(), producto3);
		repositorylista.put(producto4.getProductoId(), producto4);
	}
	@Override
	public void insert(Producto producto) {	
		Integer newId=repositorylista.size()+1;
		producto.setProductoId(newId);
		repositorylista.put(producto.getProductoId(), producto);		
	}

	@Override
	public void update(Producto producto) {
		repositorylista.put(producto.getProductoId(), producto);
		
	}

	@Override
	public void delete(Integer productoId) {
		repositorylista.remove(productoId);
		
	}

	@Override
	public Producto findById(Integer productoId) {
		return repositorylista.get(productoId);
	}
	@Override
	public Collection<Producto> findAll() {
		// TODO Auto-generated method stub
		return repositorylista.values();
	}
}
