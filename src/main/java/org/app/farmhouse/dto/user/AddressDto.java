package org.app.farmhouse.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.farmhouse.modal.user.Address;

@Data
@NoArgsConstructor
public class AddressDto {

    private Long id;
    private String addressType;
    private String name;
    private String contactNo;
    private String line1;
    private String line2;
    private String street;
    private String nearBy;
    private String city;
    private String state;
    private String country;
    private boolean defaultAdr;


    public AddressDto(Address address) {
        this.id = address.getId();
        this.addressType = address.getAddressType().toString();
        this.name = address.getName();
        this.contactNo = address.getContactNo();
        this.line1 = address.getLine1();
        this.line2 = address.getLine2();
        this.street = address.getStreet();
        this.nearBy = address.getNearBy();
        this.city = address.getCity();
        this.state = address.getState();
        this.country = address.getCountry();
        this.defaultAdr = address.isDefaultAdr();
    }


}
