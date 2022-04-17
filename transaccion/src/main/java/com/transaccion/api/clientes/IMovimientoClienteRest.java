package com.transaccion.api.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.movimiento.api.models.entity.Movimiento;

@FeignClient(name = "movimiento-apirest")
public interface IMovimientoClienteRest {
	
	@GetMapping("/listar")
	public List<Movimiento> listar();
	
}
