package com.webproject.FitnessCentre.repository;

import com.webproject.FitnessCentre.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainingRepository extends JpaRepository<Training,Long> {
    List<Training> findByName(String keyword);
    List<Training> findByDescription(String keyword);
    List<Training> findByType(String keyword);
}
