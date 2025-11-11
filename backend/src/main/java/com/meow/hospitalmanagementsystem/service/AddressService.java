package com.meow.hospitalmanagementsystem.service;

import com.meow.hospitalmanagementsystem.dto.AddressRequestDTO;
import com.meow.hospitalmanagementsystem.dto.AddressResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AddressService {
    ResponseEntity<List<AddressResponseDTO>> getAllAddresses();

    ResponseEntity<AddressResponseDTO> getAddressById(Long id);

    ResponseEntity<AddressResponseDTO> createAddress(AddressRequestDTO dto);

    ResponseEntity<AddressResponseDTO> updateAddressById(Long id, AddressRequestDTO dto);

    ResponseEntity<String> deleteAddressById(Long id);
}
