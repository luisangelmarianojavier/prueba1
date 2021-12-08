package com.idat.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.idat.Entity.Producto;
import com.idat.Repositorio.ProductoRepository;

@Service
public class ProductoServiceImpl  implements ProductoService{
	
	@Autowired
	@Qualifier("productoRepositoryImpl")
	private ProductoRepository repository;
	
	@Override
	public void insert(Producto producto) {
		repository.insert(producto);
		
	}

	@Override
	public void update(Producto producto) {
		repository.update(producto);
	}

	@Override
	public void delete(Integer productoId) {
		// TODO Auto-generated method stub
		repository.delete(productoId);
	}

	@Override
	public Producto findById(Integer productoId) {
		return repository.findById(productoId);
	}

	@Override
	public Collection<Producto> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}	
}
