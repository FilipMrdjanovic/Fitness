package com.webproject.FitnessCentre.service;

import com.webproject.FitnessCentre.entity.Trainer;
import com.webproject.FitnessCentre.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    public Trainer save(Trainer trainer) {
        return this.trainerRepository.save(trainer);
    }
}
