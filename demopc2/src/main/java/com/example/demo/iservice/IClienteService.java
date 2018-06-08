package com.example.demo.iservice;

import java.util.List;

import com.example.demo.entity.Cliente;

public interface IClienteService {

	public void save(Cliente cliente);
	public List<Cliente> findall();
	public Cliente findbyid(Long id);
}
