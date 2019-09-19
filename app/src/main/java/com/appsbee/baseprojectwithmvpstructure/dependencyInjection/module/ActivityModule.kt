package com.appsbee.baseprojectwithmvpstructure.dependencyInjection.module

import android.support.v7.app.AppCompatActivity
import com.appsbee.baseprojectwithmvpstructure.api.ApiServiceInterface
import com.appsbee.baseprojectwithmvpstructure.userInterface.activity.main.MainContract
import com.appsbee.baseprojectwithmvpstructure.userInterface.activity.main.MainPresenter
import com.appsbee.baseprojectwithmvpstructure.userInterface.activity.splash.SplashContract
import com.appsbee.baseprojectwithmvpstructure.userInterface.activity.splash.SplashPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: AppCompatActivity) {

    @Provides
    fun provideActivity(): AppCompatActivity {
        return activity
    }

    @Provides
    fun provideMainPresenter(): MainContract.Presenter {
        return MainPresenter()
    }

    @Provides
    fun provideSplashPresenter(): SplashContract.Presenter {
        return SplashPresenter()
    }

    @Provides
    fun provideApiService(): ApiServiceInterface {
        return ApiServiceInterface.create()
    }
}