package org.app.farmhouse.service.user;


import org.app.farmhouse.constants.AddressType;
import org.app.farmhouse.dto.inventory.ProductDto;
import org.app.farmhouse.dto.user.AddressDto;
import org.app.farmhouse.modal.inventory.Product;
import org.app.farmhouse.modal.user.Address;
import org.app.farmhouse.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    /**
     * Add new address object for a user
     *
     * @param dto
     */
    @Override
    public void addAddress(AddressDto dto) {
        addressRepository.save(new Address(dto));
    }

    /**
     * Update existing address for a user
     *
     * @param dto
     */
    @Override
    public void updateAddress(AddressDto dto) {
        Address address = convertExistingDto(addressRepository.findById(new Address(dto).getId()).orElseThrow(), dto);
        addressRepository.save(new Address(dto));
    }

    /**
     * Delete address using id
     *
     * @param addressId
     */
    @Override
    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }

    public Address convertExistingDto(Address address, AddressDto dto) {
        address.setAddressType(AddressType.valueOf(dto.getAddressType()));
        address.setName(dto.getName());
        address.setContactNo(dto.getContactNo());
        address.setLine1(dto.getLine1());
        address.setLine2(dto.getLine2());
        address.setStreet(dto.getStreet());
        address.setNearBy(dto.getNearBy());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setCountry(dto.getCountry());
        address.setDefaultAdr(dto.isDefaultAdr());
        return address;
    }


    public List<AddressDto> getAddress(String username) {

        return addressRepository.findAddressesByUserUsername(username).stream()
                .map(AddressDto::new)
                .collect(Collectors.toList());


    }
}
