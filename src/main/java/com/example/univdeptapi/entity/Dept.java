package com.example.univdeptapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="dept")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Dept {
    @Id
    @Column(name="dept_id")
    private int deptId;

    @Column(name="univ_id")
    private int univId;

    @Column(name="dept_name")
    private String deptName;
}
