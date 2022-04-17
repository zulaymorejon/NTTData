package com.movimiento.api.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.movimiento.api.models.entity.Movimiento;

public interface IMovimientoRepository extends PagingAndSortingRepository<Movimiento, Long> {

}
