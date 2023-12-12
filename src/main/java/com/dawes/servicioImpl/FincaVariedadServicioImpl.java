package com.dawes.servicioImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.FincaVariedadVO;
import com.dawes.repository.FincaVariedadRepository;
import com.dawes.servicio.FincaVariedadServicio;

@Service
public class FincaVariedadServicioImpl implements FincaVariedadServicio {

	@Autowired
	private FincaVariedadRepository fvr;
	
	@Override
	public <S extends FincaVariedadVO> S save(S entity) {
		return fvr.save(entity);
	}

	@Override
	public <S extends FincaVariedadVO> Iterable<S> saveAll(Iterable<S> entities) {
		return fvr.saveAll(entities);
	}

	@Override
	public Optional<FincaVariedadVO> findById(Integer id) {
		return fvr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return fvr.existsById(id);
	}

	@Override
	public Iterable<FincaVariedadVO> findAll() {
		return fvr.findAll();
	}

	@Override
	public Iterable<FincaVariedadVO> findAllById(Iterable<Integer> ids) {
		return fvr.findAllById(ids);
	}

	@Override
	public long count() {
		return fvr.count();
	}

	@Override
	public void deleteById(Integer id) {
		fvr.deleteById(id);
	}

	@Override
	public void delete(FincaVariedadVO entity) {
		fvr.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		fvr.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends FincaVariedadVO> entities) {
		fvr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		fvr.deleteAll();
	}

}
