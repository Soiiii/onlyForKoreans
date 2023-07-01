package com.project.onlyForKoreans.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



}
