package com.meow.hospitalmanagementsystem.repo;

import com.meow.hospitalmanagementsystem.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
    boolean existsByAddressLine1AndAddressLine2AndCityAndStateAndCountryAndPinCode
            (String addressLine1,
             String addressLine2,
             String city,
             String state,
             String country,
             String pinCode);
}
