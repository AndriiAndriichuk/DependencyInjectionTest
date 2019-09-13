package com.ciuc.andrii.daggertest.model.custom_garage.bike;

import android.util.Log;

import com.ciuc.andrii.daggertest.model.custom_garage.bike.bike_body.BikeBody;
import com.ciuc.andrii.daggertest.model.custom_garage.bike.steering_wheel.SteeringWheel;
import com.ciuc.andrii.daggertest.model.custom_garage.car.animation.BikeAnimation;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class BikeModule {

    public BikeBody bikeBody;
    public SteeringWheel steeringWheel;
    public BikeAnimation bikeAnimation;

    @Inject
    public BikeModule(BikeBody bikeBody, SteeringWheel steeringWheel, BikeAnimation bikeAnimation) {
        this.bikeBody = bikeBody;
        this.steeringWheel = steeringWheel;
        this.bikeAnimation = bikeAnimation;
    }

    public void drive() {
        Log.d("car", "bike is driving ");
    }

    @Provides
    public BikeBody provideBikeBody() {
        return bikeBody;
    }

    @Provides
    public SteeringWheel provideSteeringWheel() {
        return steeringWheel;
    }

    @Provides
    public BikeAnimation provideBikeAnimation() {
        return bikeAnimation;
    }

}
