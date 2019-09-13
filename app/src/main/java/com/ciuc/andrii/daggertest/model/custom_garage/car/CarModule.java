package com.ciuc.andrii.daggertest.model.custom_garage.car;

import android.util.Log;

import com.ciuc.andrii.daggertest.model.custom_garage.bike.animation.CarAnimation;
import com.ciuc.andrii.daggertest.model.custom_garage.car.engine.Engine;
import com.ciuc.andrii.daggertest.model.custom_garage.car.wheel.Wheel;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class CarModule {

    public Wheel wheel;
    public Engine engine;
    public CarAnimation carAnimation;

    @Inject
    public CarModule(Wheel wheel, Engine engine, CarAnimation carAnimation) {
        this.wheel = wheel;
        this.engine = engine;
        this.carAnimation = carAnimation;
    }

    public void drive() {
        Log.d("car", "car is driving ");
    }

    @Provides
    public Wheel provideWheel() {
        return wheel;
    }

    @Provides
    public Engine provideEngine() {
        return engine;
    }

    @Provides
    public CarAnimation provideCarAnimation() {
        return carAnimation;
    }

}
