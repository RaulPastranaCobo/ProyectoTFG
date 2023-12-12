package com.dawes.servicioImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.ArbolVariedadVO;
import com.dawes.repository.ArbolVariedadRepository;
import com.dawes.servicio.ArbolVariedadServicio;

@Service
public class ArbolVariedadServicioImpl implements ArbolVariedadServicio {

	@Autowired
	private ArbolVariedadRepository avr;
	
	@Override
	public <S extends ArbolVariedadVO> S save(S entity) {
		return avr.save(entity);
	}

	@Override
	public <S extends ArbolVariedadVO> Iterable<S> saveAll(Iterable<S> entities) {
		return avr.saveAll(entities);
	}

	@Override
	public Optional<ArbolVariedadVO> findById(Integer id) {
		return avr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return avr.existsById(id);
	}

	@Override
	public Iterable<ArbolVariedadVO> findAll() {
		return avr.findAll();
	}

	@Override
	public Iterable<ArbolVariedadVO> findAllById(Iterable<Integer> ids) {
		return avr.findAllById(ids);
	}

	@Override
	public long count() {
		return avr.count();
	}

	@Override
	public void deleteById(Integer id) {
		avr.deleteById(id);
	}

	@Override
	public void delete(ArbolVariedadVO entity) {
		avr.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		avr.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends ArbolVariedadVO> entities) {
		avr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		avr.deleteAll();
	}

}
