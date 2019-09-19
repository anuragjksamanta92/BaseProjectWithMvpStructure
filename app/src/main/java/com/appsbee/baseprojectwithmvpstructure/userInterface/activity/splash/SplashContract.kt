package com.appsbee.baseprojectwithmvpstructure.userInterface.activity.splash

import com.appsbee.baseprojectwithmvpstructure.userInterface.activity.base.BaseContract

class SplashContract {

    interface View : BaseContract.View {
        fun openLogin()
        fun openRegistration()
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun openLogin()
        fun openRegistration()
    }
}