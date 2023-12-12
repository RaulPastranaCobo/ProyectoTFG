package com.dawes.servicio;

import java.util.Optional;

import com.dawes.modelo.FincaVariedadVO;

public interface FincaVariedadServicio {

	<S extends FincaVariedadVO> S save(S entity);

	<S extends FincaVariedadVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<FincaVariedadVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<FincaVariedadVO> findAll();

	Iterable<FincaVariedadVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(FincaVariedadVO entity);

	void deleteAllById(Iterable<? extends Integer> ids);

	void deleteAll(Iterable<? extends FincaVariedadVO> entities);

	void deleteAll();

}