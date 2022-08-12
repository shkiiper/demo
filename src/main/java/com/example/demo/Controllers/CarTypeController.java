package com.example.demo.Controllers;

import com.example.demo.dto.CarTypeModel;
import com.example.demo.Entity.CarType;
import com.example.demo.Service.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cartype")
public class CarTypeController {

    @Autowired
    private CarTypeService carTypeService;


    @GetMapping(value="/all")
    public List<CarType> getAllProduct() {
        return carTypeService.getAllCarType();
    }

    @GetMapping("/{id}")
    public Optional<CarType> getById(@PathVariable("id") Long id){
        return carTypeService.getCarTypeById(id);
    }

    @PostMapping("/add")
    public CarTypeModel add(@RequestBody CarTypeModel carTypeModel) {
        carTypeService.addCarType(carTypeModel);
        return carTypeModel;
    }

    @PutMapping("/{id}")
    public CarType updatePeople(@PathVariable("id") Long id,@RequestBody CarTypeModel carTypeModel) throws  Exception{
        return carTypeService.updateById(id,carTypeModel);
    }

    @DeleteMapping("/{id}")
    public String deleteCarType(@PathVariable("id") Long id){
        carTypeService.deleteById(id);
        return  "successfully deleted!";
    }

}
