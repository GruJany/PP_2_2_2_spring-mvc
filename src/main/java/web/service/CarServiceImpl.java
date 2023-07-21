package web.service;

import org.springframework.stereotype.Component;
import web.entity.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {

    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("BMW", 123, "red"));
        cars.add(new Car("RENO", 456, "blue"));
        cars.add(new Car("Lada", 789, "red"));
        cars.add(new Car("Suzuki", 345, "white"));
        cars.add(new Car("reno", 367, "black"));
    }

    @Override
    public List<Car> getListCar(int count) {
        return cars.stream().limit(count).toList();
    }
}
