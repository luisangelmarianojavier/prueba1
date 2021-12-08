package com.idat.Repositorio;

import java.util.Collection;

import com.idat.Entity.Producto;

public interface ProductoRepository {
	
	
	//SE DEFINE LAS OPERACIONES
	public abstract void insert(Producto producto);
	public abstract void update(Producto producto);
	public abstract void delete(Integer productoId);
	public abstract Producto findById(Integer productoId);
	public abstract Collection<Producto> findAll();
	
}
