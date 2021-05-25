package com.webproject.FitnessCentre.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Grade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int Grade;

    @ManyToOne(fetch = FetchType.EAGER)
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    private Appointment appointment;

}
