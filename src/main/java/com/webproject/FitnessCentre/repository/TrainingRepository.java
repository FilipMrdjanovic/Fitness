package com.webproject.FitnessCentre.repository;

import com.webproject.FitnessCentre.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainingRepository extends JpaRepository<Training,Long> {

//    @Query(value = "SELECT t FROM TRAINING t WHERE t.name = 1")
////            + " OR description LIKE %?1%"
////            + " OR type LIKE %?1%"
////            + " OR duration LIKE %?1%")
//    List<Training> findAllByKeyword(String keyword);

    List<Training> findByName(String keyword);
    List<Training> findByDescription(String keyword);
    List<Training> findByType(String keyword);
    List<Training> findByDuration(int key);
}
