package com.appsbee.baseprojectwithmvpstructure.userInterface.activity.main

import com.appsbee.baseprojectwithmvpstructure.pojo.PlanResponse
import com.appsbee.baseprojectwithmvpstructure.userInterface.activity.base.BaseContract

class MainContract {

    interface View : BaseContract.View {
        fun showProgress(showing: Boolean)
        fun loadDataSuccess(planResponse: PlanResponse?)
        fun showErrorMessage(error: String?)

    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadPlans()
    }
}