package com.apap.tutorial3.service;
import java.util.ArrayList;
import java.util.List;

import com.apap.tutorial3.model.CarModel;
import org.springframework.stereotype.Service;

@Service
public class CarInMemoryService implements CarService{
	private List<CarModel> archiveCar;
	public CarInMemoryService() {
		archiveCar= new ArrayList<>();
		
	}
 @Override
 public void addCar(CarModel car) {
	 archiveCar.add(car);
	 
 }
 @Override
 public List<CarModel>getCarList() {
	 return archiveCar;
 }
@Override
public CarModel getCarDetail(String id) {
	for(CarModel car : archiveCar) {
		if(car.getId().equals(id)) {
			return car;
		}
	}
	return null;
}
@Override
public void updateCarAmount(String id, int amount) {
	CarModel update = getCarDetail(id);
	update.setAmount(amount);
}
@Override
public void deleteCar(String id) {
	archiveCar.removeIf(car -> car.getId().equals(id));
}

}

