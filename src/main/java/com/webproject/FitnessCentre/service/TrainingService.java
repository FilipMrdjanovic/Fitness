package com.webproject.FitnessCentre.service;

import com.webproject.FitnessCentre.entity.Appointment;
import com.webproject.FitnessCentre.entity.Training;
import com.webproject.FitnessCentre.repository.AppointmentRepository;
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

    @Autowired
    private AppointmentRepository appointmentRepository;

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
                case "PRICE":
                    int key = Integer.parseInt(keyword);
                    List<Appointment> appointments;
                    List<Training> temp = new ArrayList<>();
                    appointments = this.appointmentRepository.findByPrice(key);
                    for (Appointment a: appointments) {
                        temp.add(this.trainingRepository.getOne(a.getId()));
                    }
                    trainingList = temp;
                    break;
                case "TIME":
                    List<Appointment> appointments_time;
                    List<Training> temp_time = new ArrayList<>();
                    appointments_time = this.appointmentRepository.findByDate(keyword);
                    for (Appointment a: appointments_time) {
                        temp_time.add(this.trainingRepository.getOne(a.getId()));
                    }
                    trainingList = temp_time;
                    break;
            }
            return trainingList;
        }
        return this.trainingRepository.findAll();
    }

}
