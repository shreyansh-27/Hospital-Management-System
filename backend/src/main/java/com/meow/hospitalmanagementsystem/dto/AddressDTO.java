package com.meow.hospitalmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    public String addressLine1;
    public String addressLine2;
    public String city;
    public String state;
    public String country;
    public String pincode;
}
