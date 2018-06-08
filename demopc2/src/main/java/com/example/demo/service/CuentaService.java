package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CuentaDAO;
import com.example.demo.entity.Cuenta;
import com.example.demo.iservice.ICuentaService;
@Service
public class CuentaService implements ICuentaService {

	@Autowired
	private CuentaDAO dao;
	
	@Override
	@Transactional
	public void save(Cuenta cuenta) {
		// TODO Auto-generated method stub

		dao.save(cuenta);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Cuenta> findbycliente(Long id) {
		// TODO Auto-generated method stub
		return dao.findAllByCliente(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Cuenta> finall() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Cuenta findone(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public boolean validarcontra(Cuenta cuenta) {
		// TODO Auto-generated method stub
		Cuenta cuentaaux=  dao.findById(cuenta.getId()).orElse(null);
		
		if(cuentaaux.getClave()==cuenta.getClave()) {
			return true;
		}else {
			return false;
		}
		

	}

	@Override
	public boolean validarmax(Cuenta cuenta) {
		
		// TODO Auto-generated method stub
		if(cuenta.getMaxintentos()+1<3) {
		cuenta.setMaxintentos(cuenta.getMaxintentos()+1);
		cuenta.setClave(findone(cuenta.getId()).getClave());
		dao.save(cuenta);
		return true;
		}else {
			
		if(cuenta.getMaxintentos()<3)
		cuenta.setMaxintentos(cuenta.getMaxintentos()+1);
		
		cuenta.setClave(findone(cuenta.getId()).getClave());
		dao.save(cuenta);
		return false;
		}
		
	}

	@Override
	public void actualizarintentos(Cuenta cuenta) {
		// TODO Auto-generated method stub
		cuenta.setMaxintentos(0);
		dao.save(cuenta);
	}


}
