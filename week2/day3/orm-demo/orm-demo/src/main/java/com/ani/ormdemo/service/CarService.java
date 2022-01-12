package com.ani.ormdemo.service;
import com.ani.ormdemo.domain.Car;
import com.ani.ormdemo.repository.CarCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CarService {
    @Autowired
    private CarCrudRepo repository;

    public Car saveCar(Car car) {
        return repository.save(car);
    }
}
