package com.appsbee.baseprojectwithmvpstructure.userInterface.activity.main

import com.appsbee.baseprojectwithmvpstructure.api.ApiServiceInterface
import com.appsbee.baseprojectwithmvpstructure.pojo.PlanResponse
import com.appsbee.baseprojectwithmvpstructure.pojo.UserRequest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter : MainContract.Presenter {

    private lateinit var view: MainContract.View
    private val subscriptions = CompositeDisposable()
    private val api: ApiServiceInterface = ApiServiceInterface.create()

    override fun attach(view: MainContract.View) {
        this.view = view
    }

    override fun loadPlans() {
        val userRequest = UserRequest("1")
       /* val subscribe = api.planList(userRequest).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ planResponse: PlanResponse? ->
                view.showProgress(false)
                view.loadDataSuccess(planResponse)
            }, { error ->
                view.showProgress(false)
                view.showErrorMessage(error.localizedMessage)
            })*/
        subscriptions.add(api.planList(userRequest).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ planResponse: PlanResponse? ->
                view.showProgress(false)
                view.loadDataSuccess(planResponse)
            }, { error ->
                view.showProgress(false)
                view.showErrorMessage(error.localizedMessage)
            }))
    }
}