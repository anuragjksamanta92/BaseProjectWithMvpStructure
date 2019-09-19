package com.appsbee.baseprojectwithmvpstructure.userInterface.activity.registration

class RegistrationPresenter : RegistrationContract.Presenter {
    private lateinit var view: RegistrationContract.View
    override fun attach(view: RegistrationContract.View) {
        this.view = view
    }

}