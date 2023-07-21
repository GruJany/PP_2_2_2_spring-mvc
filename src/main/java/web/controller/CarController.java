package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarController {
    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping(value = "/cars")
    public String printWelcome(@RequestParam(required = false, defaultValue = "5") int count,
                               ModelMap model) {
        model.addAttribute("cars", service.getListCar(count));
        return "cars";
    }

}