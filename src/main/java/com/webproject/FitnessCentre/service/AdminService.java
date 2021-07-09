package com.webproject.FitnessCentre.service;

import com.webproject.FitnessCentre.entity.Administrator;
import com.webproject.FitnessCentre.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Administrator save(Administrator administrator){
        return this.adminRepository.save(administrator);
    }

    public Administrator findOne(Long id){ return this.adminRepository.getOne(id); }
}
