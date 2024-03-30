package com.example.univdeptapi.dto;

import com.example.univdeptapi.entity.Univ;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor(staticName = "of")
public class DeptResultDto<D> {
    private final String resultCode;
    private final String message;
    private final Univ univInfo;
    private final D data;
}