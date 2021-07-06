package com.webproject.FitnessCentre.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Member extends User {

    @Override
    public String toString() {
        return "Member{" +
                "assignedTrainings=" + assignedTrainings +
                '}';
    }

    @ManyToMany
    @JoinTable(name = "assigned",
            joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "appointment_id", referencedColumnName = "id"))
    private Set<Appointment> assignedTrainings;

    @ManyToMany
    @JoinTable(name = "completed",
            joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "appointment_id", referencedColumnName = "id"))
    private Set<Appointment> completedTrainings;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Grade> grade;

    public Set<Appointment> getAssignedTrainings() {
        return assignedTrainings;
    }

    public void setAssignedTrainings(Set<Appointment> assignedTrainings) {
        this.assignedTrainings = assignedTrainings;
    }

    public void addAssignedTrainings(Appointment assignedTrainings) {
        this.assignedTrainings.add(assignedTrainings);
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
