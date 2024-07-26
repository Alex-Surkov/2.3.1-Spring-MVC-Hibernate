package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.model.car.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    public List<Car> garage = List.of(
            new Car("BMW", "X5", 2008),
            new Car("Messerschmitt", "Bf.108 Taifun", 1938),
            new Car("Fairey", "Barracuda", 1948),
            new Car("Junkers", "Ju 52", 1953),
            new Car("Macchi", "C.205 Veltro", 1943)
    );

    public List<Car> getCountCars(int count) {
        if (count > 0 & count < 6) {
            return garage.subList(0, count);
        } else return garage.subList(0, 5);
    }
}
