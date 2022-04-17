package com.movimiento.api.models.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="movimientos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Movimiento implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numeroCuenta")
	private String numeroCuenta;
	
	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	private Calendar fecha;
	
	@NotEmpty(message = "El campo no puede ser vacio")
	@Column(name = "tipoMovimiento")
	private String tipoMovimiento;
	
	@Column(name = "valor")
	private Double valor;
	
	@Column(name = "saldo")
	private Double saldo;
}
