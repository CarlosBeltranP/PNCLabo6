package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.domain.Contribuyente;

@Service
public class ContribuyenteServiceImpl implements ContribuyenteService {
	
	@Autowired
	ContribuyenteDAO contribuyenteDAO;
	
	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return contribuyenteDAO.findAll();
	}

	@Override
	public void save(Contribuyente contribuyente) throws DataAccessException {
		// TODO Auto-generated method stub
		contribuyenteDAO.save(contribuyente);
	}

	@Override
	public Contribuyente findOne(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		return contribuyenteDAO.findOne(codigo);
	}

	@Override
	public int delete(Contribuyente c) throws DataAccessException {
		// TODO Auto-generated method stub
		return contribuyenteDAO.delete(c);
	}
	
}
