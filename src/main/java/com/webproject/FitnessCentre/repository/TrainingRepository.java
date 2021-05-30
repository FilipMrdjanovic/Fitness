package com.webproject.FitnessCentre.repository;

import com.webproject.FitnessCentre.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingRepository extends JpaRepository<Training,Long> {

    List<Training> findByName(String name);
    List<Training> findByType(String type);
    List<Training> findByDuration(int duration);
}
