package com.ciuc.andrii.daggertest.model.custom_garage;

import com.ciuc.andrii.daggertest.model.custom_garage.bike.BikeModule;
import com.ciuc.andrii.daggertest.model.custom_garage.car.CarModule;

import dagger.Component;

@Component(modules = {CarModule.class, BikeModule.class})
public interface CustomGarageComponent {
    CarModule getCar();
    BikeModule getBike();
}