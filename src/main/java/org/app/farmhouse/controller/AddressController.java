package org.app.farmhouse.controller;


import org.app.farmhouse.dto.user.AddressDto;
import org.app.farmhouse.modal.user.User;
import org.app.farmhouse.service.user.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @PostMapping("/add")
    public ResponseEntity<AddressDto> add(@RequestBody AddressDto dto){
        addressService.addAddress(dto);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/update")
    public  ResponseEntity<String> update(@RequestBody AddressDto dto){
        addressService.updateAddress(dto);
        return  ResponseEntity.ok("Address Updated Successfully!");
    }

    @GetMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long addressId){
        addressService.deleteAddress(addressId);
        return  ResponseEntity.ok("Address Deleted Successfully!");
    }

    @GetMapping("/get")
    public ResponseEntity<String> get(String username){
        addressService.getAddress(username);
        return ResponseEntity.ok("Address Retrieved");
    }



}
