package web.service;

import web.model.car.Car;

import java.util.List;

public interface CarService {
    List<Car> getCountCars(int count);

}
