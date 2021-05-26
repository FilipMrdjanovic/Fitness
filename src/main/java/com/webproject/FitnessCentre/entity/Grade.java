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

    public Grade(Long id, int grade, Member member, Appointment appointment) {
        this.id = id;
        Grade = grade;
        this.member = member;
        this.appointment = appointment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
