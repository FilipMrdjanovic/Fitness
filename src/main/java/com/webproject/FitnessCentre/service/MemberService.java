package com.webproject.FitnessCentre.service;

import com.webproject.FitnessCentre.entity.Member;
import com.webproject.FitnessCentre.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member findOne(Long id){
        Member member = this.memberRepository.getOne(id);
        return member;
    }
    public Member save(Member member) {
        return this.memberRepository.save(member);
    }

}
