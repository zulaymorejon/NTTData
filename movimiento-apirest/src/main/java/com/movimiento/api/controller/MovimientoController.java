package com.movimiento.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movimiento.api.models.entity.Movimiento;
import com.movimiento.api.models.service.IMovimientoService;

@RestController
@RequestMapping("/api")
public class MovimientoController {

	@Autowired
	private IMovimientoService service;
	
	@GetMapping("/movimientos")
	public List<Movimiento> listarMovimiento(){
		return service.findAll();
	}
	
	@PostMapping("/movimientos")
	public ResponseEntity<?> guardarMovimiento(@Valid @RequestBody Movimiento movimiento, BindingResult result){
		Movimiento movimientoObj = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			List<String> resultError = result.getFieldErrors().stream().map(r-> "El campo '"+r.getField()+"' "+r.getDefaultMessage()).collect(Collectors.toList());
			response.put("error", resultError);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		try {
			movimientoObj = service.save(movimiento);
		} catch (DataAccessException e) {
			response.put("error", e.getMostSpecificCause().getMessage());
			response.put("mensaje", "Se produjo un error en la aplicacion");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Movimiento creado con exito.");
		response.put("movimiento", movimientoObj);
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
	@PutMapping("/movimientos/{id}")
	public ResponseEntity<?> actualizarMovimiento(@Valid @RequestBody Movimiento movimiento, BindingResult result, @PathVariable Long id){
		Movimiento movimientoFinal = null;
		Map<String, Object> response = new HashMap<>();
		Movimiento movimientoObj = service.findById(id);
		
		if(result.hasErrors()) {
			List<String> resultError = result.getFieldErrors().stream().map(r-> "El campo '"+r.getField()+"' "+r.getDefaultMessage()).collect(Collectors.toList());
			response.put("erros", resultError);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		if(movimientoObj == null) {
			response.put("mensaje", "No existe el movimiento con el id "+id);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			
			movimientoObj.setFecha(movimiento.getFecha());
			movimientoObj.setTipoMovimiento(movimiento.getTipoMovimiento());
			movimientoObj.setValor(movimiento.getValor());
			movimientoObj.setSaldo(movimiento.getSaldo());
				
			movimientoFinal = service.save(movimientoObj);
			
		} catch (DataAccessException e) {
			response.put("error", e.getMostSpecificCause().getMessage());
			response.put("mensaje", "Se produjo un error en la aplicacion");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Movimiento actualizado con exito.");
		response.put("movimiento", movimientoFinal);
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/movimientos/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		Map<String, Object> response = new HashMap<>();
		try {
			service.deleteById(id);
		} catch (DataAccessException e) {
			response.put("error", e.getMostSpecificCause().getMessage());
			response.put("mensaje", "Se produjo un error en la aplicacion");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Movimiento eliminado con exito.");
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
		
	}
	
}
