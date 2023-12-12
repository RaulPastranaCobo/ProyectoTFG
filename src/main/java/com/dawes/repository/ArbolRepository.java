package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.ArbolVO;

@Repository
public interface ArbolRepository extends CrudRepository<ArbolVO, Integer> {

}
