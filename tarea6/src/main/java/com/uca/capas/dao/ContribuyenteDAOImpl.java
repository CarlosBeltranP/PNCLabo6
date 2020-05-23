package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Contribuyente;



@Repository
public class ContribuyenteDAOImpl implements ContribuyenteDAO {
	@PersistenceContext(unitName = "capas")
	EntityManager entityManager;

	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from contribuyente");
		Query query = entityManager.createNativeQuery(sb.toString(), Contribuyente.class);
		List<Contribuyente> res = query.getResultList();
		return res;
	}

	@Override
	public Contribuyente findOne(Integer codigo) throws DataAccessException {
		Contribuyente c = entityManager.find(Contribuyente.class, codigo);
		return c;
	}
	//Guardar estudiante
	@Override
	@Transactional
	public void save(Contribuyente c) throws DataAccessException {
		
		if(c.getC_codigo() == null) { 
			entityManager.persist(c); 
		}
		else { 
			entityManager.merge(c); 
		}
		
	}
	
	//Eliminar estudiante
	@Override
	@Transactional
	public int delete(Contribuyente c) throws DataAccessException {
		try {
			entityManager.remove(entityManager.contains(c) ? c : entityManager.merge(c));
			entityManager.flush();	
			return 1;
		}catch(Throwable ex) {
			ex.printStackTrace();
			return 1;
		}
	}

}


