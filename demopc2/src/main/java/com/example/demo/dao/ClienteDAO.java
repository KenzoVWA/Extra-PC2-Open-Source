package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cliente;
@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Long> {

}
