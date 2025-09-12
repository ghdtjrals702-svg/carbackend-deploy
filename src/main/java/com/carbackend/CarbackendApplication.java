package com.carbackend;

import com.carbackend.domain.AppUser;
import com.carbackend.domain.Car;
import com.carbackend.domain.repository.AppUserRepository;
import com.carbackend.domain.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class CarbackendApplication implements CommandLineRunner {
    private final CarRepository carRepository;
    private final AppUserRepository appUserRepository;

    public static void main(String[] args) {
        SpringApplication.run(CarbackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 애플리케이션 로딩(스프링 컨틱스트 등) 후 실행하고싶은 코드
        carRepository.save(Car.builder()
                .brand("Ford")
                .model("Mustang")
                .color("Red")
                .registrationNumber("ADF-1211")
                .modelYear(2023)
                .price(59000)
                .build());
        carRepository.save(Car.builder()
                .brand("Ford2")
                .model("Mustang2")
                .color("Blue")
                .registrationNumber("ADF-0000")
                .modelYear(2024)
                .price(69000)
                .build());
        carRepository.save(Car.builder()
                .brand("Ford3")
                .model("Mustang3")
                .color("Green")
                .registrationNumber("ADF-1111")
                .modelYear(2025)
                .price(79000)
                .build());
        for (Car car : carRepository.findAll()) {
            log.info("brand: {}, model: {}", car.getBrand(), car.getModel());
        }

        // username: user, password: user
        appUserRepository.save(AppUser.builder()
                         .username("user")
                         .password("user")
                         .role("USER")
                         .build());

        // username: admin, password: admin
        appUserRepository.save(AppUser.builder()
                .username("admin")
                .password("admin")
                .role("ADMIN")
                .build());
    }
}
