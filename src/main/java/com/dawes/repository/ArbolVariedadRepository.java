package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.ArbolVariedadVO;

@Repository
public interface ArbolVariedadRepository extends CrudRepository<ArbolVariedadVO, Integer> {

}
