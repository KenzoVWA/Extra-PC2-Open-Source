package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cuenta;
@Repository
public interface CuentaDAO extends JpaRepository<Cuenta, Long> {
	
	@Query("select f from Cuenta f join fetch f.cliente c where c.id=?1")
	public List<Cuenta> findAllByCliente(Long id);
	
}
