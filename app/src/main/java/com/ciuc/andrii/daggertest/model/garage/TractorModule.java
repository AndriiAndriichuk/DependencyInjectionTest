package com.ciuc.andrii.daggertest.model.garage;

import android.util.Log;

import com.ciuc.andrii.daggertest.model.custom_garage.car.engine.Engine;
import com.ciuc.andrii.daggertest.model.custom_garage.car.wheel.Wheel;
import com.ciuc.andrii.daggertest.model.garage.armor.Armor;
import com.ciuc.andrii.daggertest.model.garage.gun.Gun;

import javax.inject.Inject;

import dagger.Module;

@Module
public class TractorModule {

    public Armor armor;
    public Gun gun;

    @Inject
    public TractorModule(Armor armor, Gun gun) {
        this.armor = armor;
        this.gun = gun;
    }

    public void drive() {
        Log.d("car", "tractor is driving ");
    }

}
