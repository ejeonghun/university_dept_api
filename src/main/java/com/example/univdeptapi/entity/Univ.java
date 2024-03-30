package com.example.univdeptapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="univ")
@Getter
public class Univ {
    @Id
    @Column(name="univ_id")
    private int univId;

    @Column(name="univ_name")
    private String univName;

    @Column(name="region_id")
    private int regionId;

    @Column(name="univ_logo_url")
    private String univLogoUrl;
}
