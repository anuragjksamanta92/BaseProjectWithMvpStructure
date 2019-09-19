package com.appsbee.baseprojectwithmvpstructure.userInterface.activity.base

class BaseContract {

    interface Presenter<in T> {
        fun attach(view: T)
    }

    interface View {}
}