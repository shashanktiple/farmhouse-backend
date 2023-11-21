package org.app.farmhouse.service.user;


import org.app.farmhouse.dto.user.AddressDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    /**
     * Add new address object for a user
     * @param dto
     */
    void addAddress(AddressDto dto);

    /**
     * Update existing address for a user
     * @param dto
     */
    void updateAddress(AddressDto dto);

    /**
     * Delete address using id
     * @param addressId
     */
    void deleteAddress(Long addressId);

    /**
     * Get all addresses for User
     * @param dto
     */
    List<AddressDto> getAddress(String dto);

}
