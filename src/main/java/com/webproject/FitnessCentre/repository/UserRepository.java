package com.webproject.FitnessCentre.repository;

import com.webproject.FitnessCentre.entity.Member;
import com.webproject.FitnessCentre.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    void deleteById(Long id);

    User getByUsername(String username);
}
