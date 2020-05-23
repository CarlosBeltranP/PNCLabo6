package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Importancia;

public interface ImportanciaService {
	
	public List<Importancia> findAll() throws DataAccessException;
	
	public Importancia findOne(Integer codigo) throws DataAccessException;

}