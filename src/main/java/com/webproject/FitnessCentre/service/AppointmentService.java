package com.webproject.FitnessCentre.service;

import com.webproject.FitnessCentre.entity.Appointment;
import com.webproject.FitnessCentre.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> findAll (){
        List<Appointment> appointments = new ArrayList<>();
        int temp = 0;
        if(appointmentRepository.findAll()!=null)
            temp = appointmentRepository.findAll().size();
        else
            for (int i = 0; i < 50; i++){
                Appointment a = new Appointment();
                    a.setPrice(300);
                appointments.add(a);
            }
        System.out.println(temp);
        return appointments;
    }

    public Appointment findOne(Long id){
        return this.appointmentRepository.getOne(id);
    }

}
