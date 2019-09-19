package com.appsbee.baseprojectwithmvpstructure.userInterface.activity.login

import com.appsbee.baseprojectwithmvpstructure.userInterface.activity.base.BaseContract

class LoginContract  {

    interface View : BaseContract.View {}

    interface Presenter : BaseContract.Presenter<View> {}
}