package com.webproject.FitnessCentre.service;

import com.webproject.FitnessCentre.entity.Fitness;
import com.webproject.FitnessCentre.repository.FitnessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FitnessService {
    @Autowired
    private FitnessRepository fitnessRepository;

    public Fitness save(Fitness fitness) {
        return this.fitnessRepository.save(fitness);
    }

    public Fitness findOne(Long id) {
        Fitness fitness = this.fitnessRepository.getOne(id);
        return fitness;
    }
}
