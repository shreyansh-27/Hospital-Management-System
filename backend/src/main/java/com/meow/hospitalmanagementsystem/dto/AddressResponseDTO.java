package com.meow.hospitalmanagementsystem.dto;

public record AddressResponseDTO(Long id, String addressLine1, String addressLine2, String city, String state,
                                 String country, String pinCode) {
}
