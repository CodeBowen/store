package com.codewithmosh.store.services;

import com.codewithmosh.store.entities.User;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class UserService {
    private final AddressRepository addressRepository;
    private final ProfileRepository profileRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public void fetchProfile() {
        var profile = profileRepository.findById(1L).orElseThrow();
    }

    public void fetchAddress() {
        var address = addressRepository.findById(1L).orElseThrow();
    }

    @Transactional
    public void persistRelated() {
        var user1 = User.builder()
                .name("Bowen")
                .email("bowen@codewithmosh.com")
                .password("password1")
                .build();
        var profile1 = Profile.builder()
                .bio("bio1")
                .phoneNumber("phoneNumber1")
                .dateOfBirth(LocalDate.now())
                .loyaltyPoints(5)
                .build();

        user1.addProfile(profile1);
        var user2 = User.builder()
                .name("John")
                .email("john@codewithmosh.com")
                .password("password2")
                .build();

        var profile2 = Profile.builder()
                .bio("bio2")
                .phoneNumber("phoneNumber2")
                .dateOfBirth(LocalDate.now().plusDays(1))
                .loyaltyPoints(10)
                .build();
        user2.addProfile(profile2);

        var user3 = User.builder()
                .name("bob")
                .email("bob@codewithmosh.com")
                .password("password3")
                .build();

        var profile3 = Profile.builder()
                .bio("bio3")
                .phoneNumber("phoneNumber3")
                .dateOfBirth(LocalDate.now().plusDays(3))
                .loyaltyPoints(20)
                .build();


        user3.addProfile(profile3);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }

    @Transactional
    public void manageProducts() {
        productRepository.deleteById(1L);
    }

    @Transactional
    public void findByLoyalty_pointsGreaterThan() {
        var users = userRepository.findLoyalUsers(2);
        users.forEach(user -> System.out.println(user.getId() + " email: " + user.getEmail()));
    }

//    @Transactional
//    public void updateProductPrices() {
//        productRepository.updatePriceByCategory(BigDecimal.valueOf(10), (byte)1);
//    }

}
