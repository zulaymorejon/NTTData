package com.transaccion.api.models.service;

import java.util.List;

import com.transaccion.api.models.Transaccion;

public interface ITransaccionService {

	public List<Transaccion> findALL();
}
