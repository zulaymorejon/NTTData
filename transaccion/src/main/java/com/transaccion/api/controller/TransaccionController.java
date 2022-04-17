package com.transaccion.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transaccion.api.models.Transaccion;
import com.transaccion.api.models.service.ITransaccionService;

@RefreshScope
@RestController
public class TransaccionController {
	private static Logger log = LoggerFactory.getLogger(TransaccionController.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	@Qualifier("serviceFeign")
	private ITransaccionService transaccionService;
	
	@GetMapping("/listarItem")
	public List<Transaccion> findALl(){
		return transaccionService.findALL();
	}
}
