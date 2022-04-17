package com.movimiento.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.movimiento.api.models.entity.Movimiento;
import com.movimiento.api.models.repository.IMovimientoRepository;
import com.movimiento.api.models.service.MovimientoService;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {MovimientoApirestApplicationTests.class})
@SpringBootTest
class MovimientoApirestApplicationTests {

	@InjectMocks
	private MovimientoService service;
		
	@Mock
	private IMovimientoRepository repository;
	
	@Test
	void saveTest() {		
		/*
		 * when(respository.save(any(Movimiento.class))).thenReturn(DatosPrueba.
		 * empleadoResponse); Movimiento movimiento =
		 * service.save(DatosPrueba.empleadoRequest()); assertEquals("Zulay",
		 * movimiento.getNombre()); assertEquals("zulaymorejon@hotmail.com",
		 * movimiento.getEmail());
		 * assertTrue(movimiento.getApellido().contains("Morejon"));
		 * verify(repository,times(1)).save(any(Movimiento.class));
		 */
	}

}
