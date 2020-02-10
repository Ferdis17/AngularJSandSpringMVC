package org.cii.christimpact.controller;

import org.cii.christimpact.model.Address;
import org.cii.christimpact.model.Member;
import org.cii.christimpact.repository.AddressRepository;
import org.cii.christimpact.service.MapValidationErrorService;
import org.cii.christimpact.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewMember(@Valid @RequestBody Member member, BindingResult result, Address address){

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;

        if(member.getAddress() == null){
            member.setAddress(addressRepository.findByStreet(address.getStreet()));
        }
        Member member1 = memberService.saveOrUpdateMember(member);
        return new ResponseEntity<Member>(member1, HttpStatus.OK);
    }








}
