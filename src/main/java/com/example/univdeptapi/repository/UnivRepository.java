package com.example.univdeptapi.repository;

import com.example.univdeptapi.entity.Univ;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UnivRepository extends CrudRepository<Univ, Integer> {
    @Override
    List<Univ> findAll();

    List<Univ> findByRegionId(int region);
}
