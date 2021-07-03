package com.webproject.FitnessCentre.service;

import com.webproject.FitnessCentre.entity.Appointment;
import com.webproject.FitnessCentre.entity.Member;
import com.webproject.FitnessCentre.entity.Training;
import com.webproject.FitnessCentre.repository.MemberRepository;
import com.webproject.FitnessCentre.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TrainingRepository trainingRepository;

    public Member findOne(Long id){
        Member member = this.memberRepository.getOne(id);
        return member;
    }
    public Member save(Member member) {
        return this.memberRepository.save(member);
    }



}
