package com.codewithmosh.store.services;

import com.codewithmosh.store.entities.Address;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AddressService {
    private AddressRepository addressRepository;

    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElseThrow();
    }
}
