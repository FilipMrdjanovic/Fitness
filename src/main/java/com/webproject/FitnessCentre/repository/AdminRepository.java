package com.webproject.FitnessCentre.repository;

import com.webproject.FitnessCentre.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Administrator,Long> {
}
