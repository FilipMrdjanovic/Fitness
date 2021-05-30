package com.webproject.FitnessCentre.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Member extends User {


    @ManyToMany
    @JoinTable(name = "assigned",
            joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "appointment_id", referencedColumnName = "id"))
    private Set<Appointment> assignedTrainings = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "completed",
            joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "appointment_id", referencedColumnName = "id"))
    private Set<Appointment> completedTrainings = new HashSet<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Grade> grade = new HashSet<>();

    public Set<Appointment> getAssignedTrainings() {
        return assignedTrainings;
    }

    public void setAssignedTrainings(Set<Appointment> assignedTrainings) {
        this.assignedTrainings = assignedTrainings;
    }

    public Set<Appointment> getCompletedTrainings() {
        return completedTrainings;
    }

    public void setCompletedTrainings(Set<Appointment> completedTrainings) {
        this.completedTrainings = completedTrainings;
    }

    public Set<Grade> getGrade() {
        return grade;
    }

    public void setGrade(Set<Grade> grade) {
        this.grade = grade;
    }
}
