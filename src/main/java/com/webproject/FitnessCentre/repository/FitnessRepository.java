package com.webproject.FitnessCentre.repository;

import com.webproject.FitnessCentre.entity.Fitness;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FitnessRepository extends JpaRepository<Fitness, Long> {
}
