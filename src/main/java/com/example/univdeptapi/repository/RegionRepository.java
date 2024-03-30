package com.example.univdeptapi.repository;

import com.example.univdeptapi.entity.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends CrudRepository<Region, Integer> {

    @Override
    List<Region> findAll();

    Region findByRegionName(String regionName);
}
