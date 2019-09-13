package com.ciuc.andrii.daggertest.model.custom_garage.bike.animation;

import javax.inject.Inject;

public class CarAnimation {

    public String animationName;
    @Inject
    public CarAnimation(String animationName) {
        this.animationName = animationName;
    }
}
