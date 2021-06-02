package com.webproject.FitnessCentre.service;

import com.webproject.FitnessCentre.entity.Training;
import com.webproject.FitnessCentre.repository.TrainingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    public List<Training> findAll(String criteria, String keyword){
        List<Training> trainingList = new ArrayList<>();
        if(keyword != null){
            switch (criteria){
                case "NAME":
                    trainingList = this.trainingRepository.findByName(keyword);
                    break;
                case "DESCRIPTION":
                    trainingList =  this.trainingRepository.findByDescription(keyword);
                    break;
                case "TYPE":
                    trainingList =  this.trainingRepository.findByType(keyword);
                    break;
                case "DURATION":
                    int key=Integer.parseInt(keyword);
                    trainingList =  this.trainingRepository.findByDuration(key);
                    break;
            }
            return trainingList;
        }
        return this.trainingRepository.findAll();
    }

}
