package com.cliente.api.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cliente.api.models.entity.Cliente;

@Repository
public interface IClienteRepository extends PagingAndSortingRepository<Cliente, Long> {

}
