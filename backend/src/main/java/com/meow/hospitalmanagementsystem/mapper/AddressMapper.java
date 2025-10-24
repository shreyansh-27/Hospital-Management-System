package com.meow.hospitalmanagementsystem.mapper;

import com.meow.hospitalmanagementsystem.dto.AddressDTO;
import com.meow.hospitalmanagementsystem.dto.PatientRequestDTO;
import com.meow.hospitalmanagementsystem.model.Address;

public class AddressMapper {
    public static Address toAddress(PatientRequestDTO patientDTO){
        Address address = new Address();
        address.setAddressLine1(patientDTO.addressDTO.getAddressLine1());
        address.setAddressLine2((patientDTO.getAddressDTO().getAddressLine2()));
        address.setCity(patientDTO.getAddressDTO().getCity());
        address.setCountry(patientDTO.getAddressDTO().getCountry());
        address.setState(patientDTO.getAddressDTO().getState());
        address.setPincode(patientDTO.getAddressDTO().getPincode());
        return address;
    }

    public static AddressDTO toAddressDTO(Address address){
        return new AddressDTO(
                address.getAddressLine1(),
                address.getAddressLine2(),
                address.getCity(),
                address.getState(),
                address.getCountry(),
                address.getPincode()
        );
    }
}
