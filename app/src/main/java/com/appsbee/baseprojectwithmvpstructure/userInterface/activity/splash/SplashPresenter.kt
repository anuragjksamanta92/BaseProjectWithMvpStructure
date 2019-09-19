package com.appsbee.baseprojectwithmvpstructure.userInterface.activity.splash

class SplashPresenter : SplashContract.Presenter {

    private lateinit var view: SplashContract.View

    override fun attach(view: SplashContract.View) {
        this.view = view
    }

    override fun openLogin() {
        view.openLogin()
    }

    override fun openRegistration() {
        view.openRegistration()
    }
}