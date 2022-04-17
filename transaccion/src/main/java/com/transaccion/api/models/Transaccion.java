package com.transaccion.api.models;

import com.cliente.api.models.entity.Cliente;
import com.cuenta.api.models.entity.Cuenta;
import com.movimiento.api.models.entity.Movimiento;

public class Transaccion {
	private Cliente cliente;
	private Cuenta cuenta;
	private Movimiento movimiento;
	
	public Transaccion() {
		
	}
}
