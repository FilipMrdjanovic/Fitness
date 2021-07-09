package com.webproject.FitnessCentre.service;

import com.webproject.FitnessCentre.entity.Appointment;
import com.webproject.FitnessCentre.entity.Member;
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

    public List<Training> allUnassignedTrainings(Member member) {
        List<Training> temp = allTrainings();
        Set<Appointment> appointments = member.getAssignedTrainings();
        for (Appointment a : appointments) {
            temp.remove(trainingRepository.getOne(a.getTraining().getId()));

        }
        return temp;
    }

    public List<Training> allSignedTrainings(Member member) {
        List<Training> temp = new ArrayList<>();
        Set<Appointment> appointments = member.getAssignedTrainings();
        for (Appointment a : appointments) {
            temp.add(trainingRepository.getOne(a.getTraining().getId()));

        }
        return temp;
    }

    public List<Training> allCompletedTrainings(Member member) {
        List<Training> temp = new ArrayList<>();
        Set<Appointment> appointments = member.getCompletedTrainings();
        for (Appointment a : appointments) {
            temp.add(trainingRepository.getOne(a.getTraining().getId()));

        }
        return temp;
    }



    public Training findOne(Long id){
        return this.trainingRepository.getOne(id);
    }

}
