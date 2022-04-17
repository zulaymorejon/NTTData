package com.movimiento.api.models.service;

import java.util.List;

import com.movimiento.api.models.entity.Movimiento;

public interface IMovimientoService {
	
	List<Movimiento> findAll();
	Movimiento save(Movimiento movimiento);
	Movimiento findById(Long id);
	void deleteById(Long id);
}
