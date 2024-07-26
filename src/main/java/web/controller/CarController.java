package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.car.Car;
import web.service.CarServiceImpl;

import java.util.List;

@Controller
public class CarController {
    @Autowired
    private CarServiceImpl carService;

    @GetMapping(value = "/cars")
    public String printCars(ModelMap model,  @RequestParam(defaultValue = "5") int count) {
        List<Car> cars = carService.getCountCars(count);
        model.addAttribute("cars", cars);
        return "/cars";
    }
}