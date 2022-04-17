package com.cliente.api;

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

import com.cliente.api.models.entity.Cliente;
import com.cliente.api.models.repository.IClienteRepository;
import com.cliente.api.models.service.ClienteService;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {ClienteApplicationTests.class})
@SpringBootTest
class ClienteApplicationTests {

	@InjectMocks
	private ClienteService service;
		
	@Mock
	private IClienteRepository respository;
	
	@Test
	void saveTest() {		
		
		/*
		 * when(respository.save(any(Cliente.class))).thenReturn(DatosPrueba.
		 * clienteResponse); Cliente cliente =
		 * service.save(DatosPrueba.clienteRequest()); assertEquals("Activo",
		 * cliente.getEstado()); verify(respository,times(1)).save(any(Cliente.class));
		 */
		 
	}

}
