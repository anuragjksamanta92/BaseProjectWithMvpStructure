package com.appsbee.baseprojectwithmvpstructure.dependencyInjection.component

import com.appsbee.baseprojectwithmvpstructure.dependencyInjection.module.FragmentModule
import dagger.Component


@Component(modules = [FragmentModule::class])
interface FragmentComponent {
}