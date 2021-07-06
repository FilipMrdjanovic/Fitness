package com.webproject.FitnessCentre.service;

import com.webproject.FitnessCentre.entity.Hall;
import com.webproject.FitnessCentre.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class HallService {
    @Autowired
    private HallRepository hallRepository;

    public List<Hall> allHalls(){
        return this.hallRepository.findAll();
    }

//    public int getRandomNumberUsingInts(int min, int max) {
//        Random random = new Random();
//        return random.ints(min, max)
//                .findFirst()
//                .getAsInt();
//    }
//
//    public Hall randomHall(){
//        List<Hall> halls = this.hallRepository.findAll();
//        int random = getRandomNumberUsingInts(1,halls.size());
//        return halls.get(random);
//    }
}

