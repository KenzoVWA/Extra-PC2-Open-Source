package com.example.demo.iservice;

import java.util.List;

import com.example.demo.entity.Movimiento;

public interface IMovimientoService {
	
	public void save(Movimiento movimiento);
	public List<Movimiento> findbycuenta(Long id);
	public List<Movimiento> findall();
}
