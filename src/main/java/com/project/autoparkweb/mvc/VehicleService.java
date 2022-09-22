package com.project.autoparkweb.mvc;

import com.project.autoparkweb.mvc.model.dao.CarBrand;
import com.project.autoparkweb.mvc.model.dao.Vehicle;
import com.project.autoparkweb.mvc.model.repository.CarBrandRepository;
import com.project.autoparkweb.mvc.model.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private CarBrandRepository carBrandRepository;

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public List<CarBrand> getAllBrands() {
        List<CarBrand> car = carBrandRepository.findAll();
//        BrandProperty brandProperty = mapper.getBrandPrperty(car.get(0))
        return car;
    }

}
