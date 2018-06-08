package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="cuenta")
public class Cuenta implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	@NotNull
	public String banco;
	
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;
    
    @NotNull
    private int nrocta;
    
    @NotNull
    private Long saldobase;
    
    @OneToMany(mappedBy="cuenta",fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
    public List<Movimiento> movimientos;

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	
	
	public Cuenta() {
		movimientos=new ArrayList<>();
	}
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getNrocta() {
		return nrocta;
	}

	public void setNrocta(int nrocta) {
		this.nrocta = nrocta;
	}

	public Long getSaldobase() {
		return saldobase;
	}

	public void setSaldobase(Long saldobase) {
		this.saldobase = saldobase;
	}

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
    
	
}
