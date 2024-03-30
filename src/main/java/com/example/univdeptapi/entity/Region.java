package com.example.univdeptapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="region")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Region {
    @Id
    @Column(name="region_id")
    private int regionId;

    @Column(name="region_name")
    private String regionName;
}
