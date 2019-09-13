package com.ciuc.andrii.daggertest.model.custom_garage.car.animation;

import javax.inject.Inject;

public class BikeAnimation {

    public String animationName;
    @Inject
    public BikeAnimation(String animationName) {
        this.animationName = animationName;
    }
}
