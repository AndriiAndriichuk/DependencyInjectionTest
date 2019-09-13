package com.ciuc.andrii.daggertest.model.custom_garage.car.wheel;

import javax.inject.Inject;

public class Wheel {

    Disk disk;
    Tires tires;

    @Inject
    public Wheel(Disk disk, Tires tires) {
        this.disk = disk;
        this.tires = tires;
    }
}
