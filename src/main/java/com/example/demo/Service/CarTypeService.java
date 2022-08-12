package com.example.demo.Service;

import com.example.demo.Entity.CarType;
import com.example.demo.dto.CarTypeModel;
import com.example.demo.Repository.CarTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarTypeService {

    @Autowired
    private CarTypeRepository carTypeRepository;


    public List<CarType> getAllCarType()
    {
        return carTypeRepository.findAll();
    }

    public Optional<CarType> getCarTypeById(Long id){
        return carTypeRepository.findById(id);
    }

    public  CarType addCarType(CarTypeModel model){
        CarType carType = new CarType(1L,model.getName());
        return carTypeRepository.save(carType);
    }

    public void deleteById(Long id) {carTypeRepository.deleteById(id);
    }

    public CarType updateById(Long id,CarTypeModel model) throws Exception {
        return carTypeRepository.findById(id)
                .map(updateCarType -> {
                    updateCarType.setName(model.getName());
                    return carTypeRepository.save(updateCarType);
                }).orElseThrow(Exception::new);
    }
    
}