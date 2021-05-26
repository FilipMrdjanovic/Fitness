package com.webproject.FitnessCentre.repository;

import com.webproject.FitnessCentre.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
