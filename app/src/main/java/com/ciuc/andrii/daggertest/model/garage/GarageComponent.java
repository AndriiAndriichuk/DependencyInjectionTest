package com.ciuc.andrii.daggertest.model.garage;

import dagger.Component;

@Component(modules = TractorModule.class)
public interface GarageComponent {
    TractorModule getTractor();
}