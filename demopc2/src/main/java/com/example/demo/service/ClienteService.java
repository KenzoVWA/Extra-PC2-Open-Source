package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ClienteDAO;
import com.example.demo.entity.Cliente;
import com.example.demo.iservice.IClienteService;
@Service
public class ClienteService implements IClienteService {

	@Autowired
	private ClienteDAO dao;
	
	@Override
	@Transactional
	public void save(Cliente cliente) {
		// TODO Auto-generated method stub
		dao.save(cliente);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findall() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente findbyid(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

}
