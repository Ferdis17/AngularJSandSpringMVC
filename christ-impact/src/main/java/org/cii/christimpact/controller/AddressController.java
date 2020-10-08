//package org.cii.christimpact.controller;
//
//
//import org.cii.christimpact.model.Address;
//import org.cii.christimpact.service.AddressService;
//import org.cii.christimpact.service.MapValidationErrorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("api/addresses")
//public class AddressController {
//
//
//    @Autowired
//    private AddressService addressService;
//
//    @Autowired
//    private MapValidationErrorService mapValidationErrorService;
//
//    @PostMapping("")
//    public ResponseEntity<?> createAddress(@Valid @RequestBody Address address, BindingResult result){
//
//        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
//        if(errorMap!=null) return errorMap;
//
//        Address newAddress =  addressService.SaveOrUpdate(address);
//        return new ResponseEntity<Address>(newAddress, HttpStatus.OK);
//    }
//}
