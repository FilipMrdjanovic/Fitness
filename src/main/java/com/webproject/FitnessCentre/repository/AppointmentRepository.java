package com.webproject.FitnessCentre.repository;

import com.webproject.FitnessCentre.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Appointment findByTrainingId(Long id);

    List<Appointment> findByPrice(int number);
    List<Appointment> findByDate(String date);
}
