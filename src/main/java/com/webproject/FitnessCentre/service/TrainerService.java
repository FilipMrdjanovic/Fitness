package com.webproject.FitnessCentre.service;

import com.webproject.FitnessCentre.entity.Trainer;
import com.webproject.FitnessCentre.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    public Trainer save(Trainer trainer) {
        return this.trainerRepository.save(trainer);
    }

    public List<Trainer> findAll() {
        List<Trainer> trainers = this.trainerRepository.findAll();
        List<Trainer> allowedTrainers = new ArrayList<>();
        for (Trainer trainer : trainers) {
            if (!trainer.getAllowed()){
                allowedTrainers.add(trainer);
            }
        }
        return allowedTrainers;
    }

    public List<Trainer> findAllAllowed() {
        List<Trainer> trainers = this.trainerRepository.findAll();
        List<Trainer> allowedTrainers = new ArrayList<>();
        for (Trainer trainer : trainers) {
            if (trainer.getAllowed() && (trainer.getFitness() == null)){
                allowedTrainers.add(trainer);
            }
        }
        return allowedTrainers;
    }

    public Trainer findOne(Long id) {
        Trainer trainer = this.trainerRepository.getOne(id);
        return trainer;
    }

    public void delete(Long id) {
        this.trainerRepository.deleteById(id);
    }
}
