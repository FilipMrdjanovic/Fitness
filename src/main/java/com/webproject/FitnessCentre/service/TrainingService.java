package com.webproject.FitnessCentre.service;

import com.webproject.FitnessCentre.entity.Training;
import com.webproject.FitnessCentre.repository.TrainingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;


    public List<Training> findAll() {
        List<Training> employees = this.trainingRepository.findAll();
        return employees;
    }
}
