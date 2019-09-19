package com.appsbee.baseprojectwithmvpstructure.dependencyInjection.module

import android.app.Application
import com.appsbee.baseprojectwithmvpstructure.BaseApp
import com.appsbee.baseprojectwithmvpstructure.dependencyInjection.scope.PreApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    @PreApplication
    fun provideApplication(): Application {
        return baseApp
    }
}