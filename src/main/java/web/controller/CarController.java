package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarController {
    private CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping(value = "/cars")
    public String printWelcome(@RequestParam(value = "count", required = false, defaultValue = "5") int count,
                               ModelMap model) {
        if(count > 5) {
            count = 5;
        }
        model.addAttribute("cars", service.getListCar(count));
        return "cars";
    }

}