package com.dawes.servicioImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.VariedadTratamientoFincaVO;
import com.dawes.repository.VariedadTratamientoFincaRepository;
import com.dawes.servicio.VariedadTratamientoFincaServicio;

@Service
public class VariedadTratamientoFincaServicioImpl implements VariedadTratamientoFincaServicio {

	@Autowired
	private VariedadTratamientoFincaRepository vtfr;

	
	@Override
	public <S extends VariedadTratamientoFincaVO> S save(S entity) {
		return vtfr.save(entity);
	}

	@Override
	public <S extends VariedadTratamientoFincaVO> Iterable<S> saveAll(Iterable<S> entities) {
		return vtfr.saveAll(entities);
	}

	@Override
	public Optional<VariedadTratamientoFincaVO> findById(Integer id) {
		return vtfr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return vtfr.existsById(id);
	}

	@Override
	public Iterable<VariedadTratamientoFincaVO> findAll() {
		return vtfr.findAll();
	}

	@Override
	public Iterable<VariedadTratamientoFincaVO> findAllById(Iterable<Integer> ids) {
		return vtfr.findAllById(ids);
	}

	@Override
	public long count() {
		return vtfr.count();
	}

	@Override
	public void deleteById(Integer id) {
		vtfr.deleteById(id);
	}

	@Override
	public void delete(VariedadTratamientoFincaVO entity) {
		vtfr.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		vtfr.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends VariedadTratamientoFincaVO> entities) {
		vtfr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		vtfr.deleteAll();
	}

}
