package com.cliente.api.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Builder
@Entity
public class Cliente extends Persona implements Serializable {
	
	@NotEmpty(message = "El campo no puede ser vacio")
	@Column(name = "password")
	private String password;
	
	@NotEmpty(message = "El campo no puede ser vacio")
	@Column(name = "estado")
	private String estado;
	
	private static final long serialVersionUID = 4334455564095195932L;

}
