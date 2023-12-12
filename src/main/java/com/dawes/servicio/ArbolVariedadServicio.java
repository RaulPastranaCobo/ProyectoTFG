package com.dawes.servicio;

import java.util.Optional;

import com.dawes.modelo.ArbolVariedadVO;

public interface ArbolVariedadServicio {

	<S extends ArbolVariedadVO> S save(S entity);

	<S extends ArbolVariedadVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<ArbolVariedadVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<ArbolVariedadVO> findAll();

	Iterable<ArbolVariedadVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(ArbolVariedadVO entity);

	void deleteAllById(Iterable<? extends Integer> ids);

	void deleteAll(Iterable<? extends ArbolVariedadVO> entities);

	void deleteAll();

}