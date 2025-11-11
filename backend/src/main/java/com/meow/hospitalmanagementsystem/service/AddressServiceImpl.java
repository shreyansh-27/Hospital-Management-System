package com.meow.hospitalmanagementsystem.service;

import com.meow.hospitalmanagementsystem.dto.AddressRequestDTO;
import com.meow.hospitalmanagementsystem.dto.AddressResponseDTO;
import com.meow.hospitalmanagementsystem.exception.ResourceAlreadyExistsException;
import com.meow.hospitalmanagementsystem.exception.ResourceNotFoundException;
import com.meow.hospitalmanagementsystem.mapper.AddressMapper;
import com.meow.hospitalmanagementsystem.model.Address;
import com.meow.hospitalmanagementsystem.repo.AddressRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;

    public AddressServiceImpl(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    @Override
    public ResponseEntity<List<AddressResponseDTO>> getAllAddresses() {
        boolean isEmpty = addressRepo.findAll().isEmpty();

        if (isEmpty) {
            throw new ResourceNotFoundException("Address", "List empty");
        }

        List<AddressResponseDTO> addressResponseDTOList =
                addressRepo.findAll().stream().map(AddressMapper::toAddressResponseDTO).toList();
        return ResponseEntity.ok(addressResponseDTOList);
    }

    @Override
    public ResponseEntity<AddressResponseDTO> getAddressById(Long id) {
        Address address = addressRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address", id));
        return ResponseEntity.ok(AddressMapper.toAddressResponseDTO(address));
    }

    @Override
    public ResponseEntity<AddressResponseDTO> createAddress(AddressRequestDTO dto) {
        boolean exists = addressRepo
                .existsByAddressLine1AndAddressLine2AndCityAndStateAndCountryAndPinCode(
                        dto.getAddressLine1(),
                        dto.getAddressLine2(),
                        dto.getCity(),
                        dto.getState(),
                        dto.getCountry(),
                        dto.getPinCode());

        if (exists) {
            throw new ResourceAlreadyExistsException("Address");
        }

        Address address = AddressMapper.toAddress(dto);
        Address savedAddress = addressRepo.save(address);
        return ResponseEntity.ok(AddressMapper.toAddressResponseDTO(savedAddress));
    }

    @Override
    public ResponseEntity<AddressResponseDTO> updateAddressById(Long id, AddressRequestDTO dto) {
        boolean exists = addressRepo.existsById(id);

        if (!exists) {
            throw new ResourceNotFoundException("Address", id);
        }

        Address address = AddressMapper.toAddress(dto);
        Address savedAddress = addressRepo.save(address);
        return ResponseEntity.ok(AddressMapper.toAddressResponseDTO(savedAddress));
    }

    @Override
    public ResponseEntity<String> deleteAddressById(Long id) {
        boolean exists = addressRepo.existsById(id);

        if (!exists) {
            throw new ResourceNotFoundException("Address", id);
        }

        addressRepo.deleteById(id);
        return ResponseEntity.ok("Address deleted!");
    }
}
