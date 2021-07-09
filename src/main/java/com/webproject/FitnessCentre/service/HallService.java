package com.webproject.FitnessCentre.service;

import com.webproject.FitnessCentre.entity.Hall;
import com.webproject.FitnessCentre.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class HallService {
    @Autowired
    private HallRepository hallRepository;

    public List<Hall> allHalls(){
        return this.hallRepository.findAll();
    }

    public Hall findOne(Long id){
        return this.hallRepository.getOne(id);
    }
    public Hall save(Hall hall){
        return this.hallRepository.save(hall);
    }
    public List<Hall> findAll(){
        return this.hallRepository.findAll();
    }

    public List<Hall> findAllNullFitness() {
        List<Hall> halls = this.hallRepository.findAll();
        List<Hall> tempHalls = new ArrayList<>();
        for (Hall hall : halls) {
            if (hall.getFitness() == null){
                tempHalls.add(hall);
            }
        }
        return tempHalls;
    }

    public List<Hall> findAllFitness(Long id){
        List<Hall> halls = findAll();
        List<Hall> hallList = new ArrayList<>();
        for(Hall h : halls){
            if(h.getFitness() != null && h.getFitness().getId().equals(id)){
                hallList.add(h);
            }
        }
//            if(!h.getFitness().getId().equals(id) || h.getFitness().getId().equals(null))
//                halls.remove(h);

        return hallList;
    }

    public void delete(Long id) {
        this.hallRepository.deleteById(id);
    }
}

