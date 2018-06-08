package com.example.demo.iservice;

import java.util.List;

import com.example.demo.entity.Cuenta;

public interface ICuentaService {

		public void save(Cuenta cuenta);
		public List<Cuenta> findbycliente(Long id);
		public List<Cuenta> finall();
		public Cuenta findone(Long id);
		public boolean validarcontra(Cuenta cuenta);
		public boolean validarmax(Cuenta cuenta);
		public void actualizarintentos(Cuenta cuenta);
}
