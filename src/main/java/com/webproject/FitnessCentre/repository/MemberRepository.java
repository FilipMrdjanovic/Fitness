package com.webproject.FitnessCentre.repository;

import com.webproject.FitnessCentre.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
