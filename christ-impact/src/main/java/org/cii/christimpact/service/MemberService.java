package org.cii.christimpact.service;


import org.cii.christimpact.model.Member;
import org.cii.christimpact.repository.AddressRepository;
import org.cii.christimpact.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AddressRepository addressRepository;


    public Member saveOrUpdateMember(Member member) {
        return memberRepository.save(member);
    }

    public Iterable<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    public Member findMember(String name) {

        return memberRepository.findByLastName(name);
    }

    public void deleteMember(String name) {
        memberRepository.delete(findMember(name));
    }


}
