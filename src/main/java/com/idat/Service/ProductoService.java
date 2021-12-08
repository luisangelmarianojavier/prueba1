package com.idat.Service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.idat.Entity.Producto;

public interface ProductoService {
	
	//DEFINE LOS SERVICIOS PARA EL CONTROLADOR
	
	public abstract void insert(Producto producto);
	public abstract void update(Producto producto);
	public abstract void delete(Integer productoId);
	public abstract Producto findById(Integer productoId);
	public abstract Collection<Producto> findAll();
}
