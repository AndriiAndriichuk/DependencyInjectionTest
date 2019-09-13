package com.ciuc.andrii.daggertest.model.custom_garage.car.engine;

import javax.inject.Inject;


public class Engine {

    Block block;
    Cylinders cylinders;
    SparkPlugs sparkPlugs;

    @Inject
    public Engine(Block block, Cylinders cylinders, SparkPlugs sparkPlugs) {
        this.block = block;
        this.cylinders = cylinders;
        this.sparkPlugs = sparkPlugs;
    }
}
