package com.example.univdeptapi.service;

import com.example.univdeptapi.entity.Dept;
import com.example.univdeptapi.entity.Region;
import com.example.univdeptapi.entity.Univ;
import com.example.univdeptapi.repository.DeptRepository;
import com.example.univdeptapi.repository.RegionRepository;
import com.example.univdeptapi.repository.UnivRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiService {

    private RegionRepository regionRepository;
    private UnivRepository univRepository;
    private DeptRepository deptRepository;

    @Autowired
    public ApiService(RegionRepository regionRepository, UnivRepository univRepository, DeptRepository deptRepository) {
        this.regionRepository = regionRepository;
        this.univRepository = univRepository;
        this.deptRepository = deptRepository;
    }

    public List<Region> Regionlist() {
        try {
            return regionRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("지역 리스트를 반환할 수 없습니다.", e);
        }
    }

    public List<Univ> RegionInUniv(String region) {
        try {
            Region regionInfo = regionRepository.findByRegionName(region);
            if (regionInfo == null) {
                throw new IllegalArgumentException("해당 지역을 찾을 수 없습니다.");
            }
            return univRepository.findByRegionId(regionInfo.getRegionId());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("해당 지역을 찾을 수 없습니다. : " + region, e);
        }
    }

    public List<Dept> UnivDeptList(int univId) {
        try {
            return deptRepository.findByUnivId(univId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("해당 학교 코드를 찾을 수 없습니다. : " + univId, e);
        }
    }

    public Univ UnivInfo(int univId) {
        try {
            return univRepository.findById(univId).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("해당 학교 코드를 찾을 수 없습니다. : " + univId, e);
        }
    }
}
