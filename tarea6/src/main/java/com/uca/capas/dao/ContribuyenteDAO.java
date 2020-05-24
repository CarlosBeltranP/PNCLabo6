package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Contribuyente;


public interface ContribuyenteDAO {
	public List<Contribuyente> findAll() throws DataAccessException;

	public Contribuyente findOne(Integer codigo) throws DataAccessException;

	public void save(Contribuyente c) throws DataAccessException;

	int delete(Contribuyente c) throws DataAccessException;
}
