package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.FincaVariedadVO;

@Repository
public interface FincaVariedadRepository extends CrudRepository<FincaVariedadVO, Integer> {

}
