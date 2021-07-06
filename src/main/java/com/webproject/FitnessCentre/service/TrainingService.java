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
import java.util.Set;

@Service
public class TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Training> allTrainings(){
        return this.trainingRepository.findAll();
    }

    public List<Training> allUnassignedTrainings(Set<Appointment> appointments){
        List<Training> temp = allTrainings();
        if(appointments.isEmpty())
            return allTrainings();
        else
            for (Training t : temp) {
                for (Appointment a : appointments) {
                    if (t.getId().equals(a.getTraining().getId()))
                        temp.remove(t);
                }
            }
        return  temp;
    }

    public Training findOne(Long id){
        return this.trainingRepository.getOne(id);
    }

}
