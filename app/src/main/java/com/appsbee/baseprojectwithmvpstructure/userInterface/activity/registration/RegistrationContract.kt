package com.appsbee.baseprojectwithmvpstructure.userInterface.activity.registration

import com.appsbee.baseprojectwithmvpstructure.userInterface.activity.base.BaseContract

class RegistrationContract {

    interface View : BaseContract.View {}

    interface Presenter : BaseContract.Presenter<View> {}
}