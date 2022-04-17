package com.movimiento.api.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movimiento.api.models.entity.Movimiento;
import com.movimiento.api.models.repository.IMovimientoRepository;

@Service
public class MovimientoService implements IMovimientoService {
	
	@Autowired
	private IMovimientoRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Movimiento> findAll(){
		return (List<Movimiento>) repository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Movimiento findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Movimiento save(Movimiento movimiento) {
		return repository.save(movimiento);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
