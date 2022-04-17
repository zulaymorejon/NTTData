package com.transaccion.api.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.movimiento.api.models.entity.Movimiento;
import com.transaccion.api.clientes.IMovimientoClienteRest;
import com.transaccion.api.models.Transaccion;

@Service("serviceFeign")
@Primary
public class TransaccionFeign {

	@Autowired
	private IMovimientoClienteRest movimientoClienteRest;
	
	public List<Transaccion> findALL() {
		return movimientoClienteRest.listar().stream().map(p -> new Transaccion()).collect(Collectors.toList());
	}
	
}
