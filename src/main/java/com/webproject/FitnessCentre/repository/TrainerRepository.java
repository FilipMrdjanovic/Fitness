package com.webproject.FitnessCentre.repository;

import com.webproject.FitnessCentre.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TrainerRepository extends JpaRepository<Trainer,Long> {
//    @Modifying
//    @Query("update trainer t set t.is_allowed = true where u.id = 1")
//    void allowTrainer(Long id_active);
}
