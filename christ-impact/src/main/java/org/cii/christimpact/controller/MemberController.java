package org.cii.christimpact.controller;

import org.cii.christimpact.model.Address;
import org.cii.christimpact.model.Member;
//import org.cii.christimpact.repository.AddressRepository;
import org.cii.christimpact.service.MapValidationErrorService;
import org.cii.christimpact.service.MemberService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

//    @Autowired
//    private AddressRepository addressRepository;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @GetMapping("/all")
    public Iterable<Member> findAllMembers(){

        return memberService.findAllMembers();
    }
    @PostMapping("")
    public ResponseEntity<?> createNewMember(@Valid @RequestBody Member member, BindingResult result, Address address){

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;

        if(member.getAddress() == null){
            member.setAddress(address);
        }
        Member member1 = memberService.saveOrUpdateMember(member);
        return new ResponseEntity<Member>(member1, HttpStatus.OK);
    }

    @DeleteMapping("/{lastName}")
    public void deleteMember(@PathVariable String lastName){

            memberService.deleteMember(lastName);
    }
}
