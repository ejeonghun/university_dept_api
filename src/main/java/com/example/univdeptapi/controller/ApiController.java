package com.example.univdeptapi.controller;

import com.example.univdeptapi.dto.DeptResultDto;
import com.example.univdeptapi.dto.ResultDto;
import com.example.univdeptapi.entity.Dept;
import com.example.univdeptapi.entity.Region;
import com.example.univdeptapi.entity.Univ;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.univdeptapi.service.ApiService;

import java.util.List;

@Tag(name="API List", description = "")
@RestController
@RequiredArgsConstructor
public class ApiController {
    private final ApiService apiService;


    @Operation(summary = "지역조회", description = "지역의 이름과 id값을 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "500", description = "조회 실패")
    })
    @GetMapping("/api/region/list")
    public ResultDto<Object> regionList() {
        try {
            List<Region> regions = apiService.Regionlist();
            return ResultDto.of("200", "조회 성공", regions);
        } catch (Exception e) {
            // 예외 발생 시 처리
            e.printStackTrace(); // 예외 로그 출력
            return ResultDto.of("500", "조회 실패: " + e.getMessage(), null);
        }
    }

    @Operation(summary = "지역대학조회", description = "지역의 id값으로 해당 지역의 대학교 리스트를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "500", description = "조회 실패")
    })
    @GetMapping("/api/univ/list")
    public ResultDto<Object> univList(@RequestParam String region) {
        try {
            List<Univ> univs = apiService.RegionInUniv(region);
            return ResultDto.of("200", "조회 성공", univs);
        } catch (Exception e) {
            // 예외 발생 시 처리
            e.printStackTrace(); // 예외 로그 출력
            return ResultDto.of("500", "조회 실패: " + e.getMessage(), null);
        }
    }

    @Operation(summary = "대학 내 학과 조회", description = "해당 대학교의 id값으로 대학 내 학과 리스트를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "500", description = "조회 실패")
    })
    @GetMapping("/api/univ/dept")
    public DeptResultDto<Object> univDept(@RequestParam int univ_id) {
        try {
            List<Dept> depts = apiService.UnivDeptList(univ_id);
            Univ univInfo = apiService.UnivInfo(univ_id);
            return DeptResultDto.of("200", "조회 성공",univInfo, depts);
        } catch (Exception e) {
            // 예외 발생 시 처리
            e.printStackTrace(); // 예외 로그 출력
            return DeptResultDto.of("500", "조회 실패: " + e.getMessage(), null,null);
        }
    }
}
