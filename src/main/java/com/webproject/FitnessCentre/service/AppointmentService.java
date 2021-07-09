package com.webproject.FitnessCentre.service;

import com.webproject.FitnessCentre.entity.Appointment;
import com.webproject.FitnessCentre.entity.Hall;
import com.webproject.FitnessCentre.entity.Trainer;
import com.webproject.FitnessCentre.entity.Training;
import com.webproject.FitnessCentre.repository.AppointmentRepository;
import com.webproject.FitnessCentre.repository.HallRepository;
import com.webproject.FitnessCentre.repository.TrainerRepository;
import com.webproject.FitnessCentre.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private TrainingRepository trainingRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private HallRepository hallRepository;


    public int rBetweenGenerator(int min, int max, int div)
    {
        int res = min + ((new Random()).nextInt(max - min + 1));
        for(int i = res; i < res + div; i++)
        {
            if( i % div == 0 )
            {
                return i;
            }
        } return -1; //error
    }

    public int getRandomNumberUsingInts(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }

//    public void Create(List<Training> trainings, List<Trainer> trainers, List<Hall> halls){
    public void Create(List<Training> trainings){
        List<Appointment> appointments = appointmentRepository.findAll();
        int i = 0;
        for (Training t: trainings) {
            appointments.get(i).setTraining(t);
            save(appointments.get(i));
            i++;
        }
    }
    public Appointment save(Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> findAll (){
        return this.appointmentRepository.findAll();
    }

    public Appointment findOne(Long id){
        return this.appointmentRepository.getOne(id);
    }

    public Appointment findOneByTraining(Long id){
        List<Appointment> appointments = appointmentRepository.findAll();
        for (Appointment a: appointments) {
            if(a.getTraining().getId().equals(id))
                return this.appointmentRepository.findByTrainingId(id);
        }
        return null;
    }

}
