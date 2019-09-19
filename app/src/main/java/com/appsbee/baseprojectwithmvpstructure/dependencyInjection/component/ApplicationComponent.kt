package com.appsbee.baseprojectwithmvpstructure.dependencyInjection.component

import com.appsbee.baseprojectwithmvpstructure.BaseApp
import com.appsbee.baseprojectwithmvpstructure.dependencyInjection.module.ApplicationModule
import dagger.Component

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: BaseApp)
}