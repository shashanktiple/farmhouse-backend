package org.app.farmhouse.modal.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.farmhouse.constants.AddressType;
import org.app.farmhouse.dto.user.AddressDto;

import java.io.Serializable;

@Entity(name = "addresses")
@Data
@NoArgsConstructor
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;
    @Column(length = 50)
    private String name;
    private String contactNo;
    @Column(length = 100)
    private String line1;
    @Column(length = 50)
    private String line2;
    @Column(length = 50)
    private String street;
    @Column(length = 100)
    private String nearBy;
    @Column(length = 50)
    private String city;
    private int zipcode;
    @Column(length = 100)
    private String state;
    @Column(length = 50)
    private String country;
    private boolean defaultAdr;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "username")
    private User user;


    public Address(AddressDto dto){
        this.id = dto.getId();
        this.addressType = AddressType.valueOf(dto.getAddressType());
        this.name = dto.getName();
        this.contactNo = dto.getContactNo();
        this.line1 = dto.getLine1();
        this.line2 = dto.getLine2();
        this.street = dto.getStreet();
        this.nearBy = dto.getNearBy();
        this.city = dto.getCity();
        this.state = dto.getState();
        this.country = dto.getCountry();
        this.defaultAdr = dto.isDefaultAdr();
    }
}

