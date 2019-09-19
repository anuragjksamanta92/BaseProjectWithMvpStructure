package com.appsbee.baseprojectwithmvpstructure.dependencyInjection.component

import com.appsbee.baseprojectwithmvpstructure.dependencyInjection.module.ActivityModule
import com.appsbee.baseprojectwithmvpstructure.userInterface.activity.base.BaseActivity
import com.appsbee.baseprojectwithmvpstructure.userInterface.activity.login.LoginActivity
import com.appsbee.baseprojectwithmvpstructure.userInterface.activity.main.MainActivity
import com.appsbee.baseprojectwithmvpstructure.userInterface.activity.registration.RegistrationActivity
import com.appsbee.baseprojectwithmvpstructure.userInterface.activity.splash.SplashActivity
import dagger.Component

@Component(modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(splashActivity: SplashActivity)
    fun inject(loginActivity: LoginActivity)
    fun inject(registrationActivity: RegistrationActivity)
}