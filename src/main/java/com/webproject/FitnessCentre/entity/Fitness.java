package com.webproject.FitnessCentre.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Fitness implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String centralNumber;

    @Column
    private String email;

    @OneToMany(mappedBy = "fitness", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Trainer> trainers = new HashSet<>();

    @OneToMany(mappedBy = "fitness", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Hall> halls = new HashSet<>();

}

//    @ManyToMany
//    @JoinTable(name = "FITNESS_TIMETABLE",
//            joinColumns = {@JoinColumn(name = "id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "price", referencedColumnName = "id")})
//    private Set<Fitness> timetable = new HashSet<>();

//@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//@JoinTable(name = "USER_ROLES", joinColumns = {@JoinColumn(name = "USER_ID"),
//        @JoinColumn(name = "COMPANY_ID"), @JoinColumn(name="PRODUCT_ID")}, inverseJoinColumns =
//        {@JoinColumn(name = "ROLE_ID"), @JoinColumn(name = "COMPANY_ID"),
//                @JoinColumn(name="PRODUCT_ID")})