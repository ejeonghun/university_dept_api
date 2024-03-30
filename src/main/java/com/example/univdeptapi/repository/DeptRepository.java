package com.example.univdeptapi.repository;

import com.example.univdeptapi.entity.Dept;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeptRepository extends CrudRepository<Dept, Integer> {

    List<Dept> findByUnivId(int univId);
}
