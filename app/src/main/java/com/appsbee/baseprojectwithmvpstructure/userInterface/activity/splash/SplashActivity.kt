package com.appsbee.baseprojectwithmvpstructure.userInterface.activity.splash

import android.content.Intent
import android.os.Bundle
import com.appsbee.baseprojectwithmvpstructure.R
import com.appsbee.baseprojectwithmvpstructure.dependencyInjection.component.DaggerActivityComponent
import com.appsbee.baseprojectwithmvpstructure.dependencyInjection.module.ActivityModule
import com.appsbee.baseprojectwithmvpstructure.userInterface.activity.base.BaseActivity
import com.appsbee.baseprojectwithmvpstructure.userInterface.activity.login.LoginActivity
import com.appsbee.baseprojectwithmvpstructure.userInterface.activity.main.MainActivity
import com.appsbee.baseprojectwithmvpstructure.userInterface.activity.registration.RegistrationActivity
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashContract.View {

    @Inject
    lateinit var presenter: SplashContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        injectDependency()

        presenter.attach(this)

        buttonLogin.setOnClickListener {
            presenter.openLogin()
        }

        buttonSignUp.setOnClickListener {
            presenter.openRegistration()
        }
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)
    }

    override fun openLogin() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun openRegistration() {
        val intent = Intent(this, RegistrationActivity::class.java)
        startActivity(intent)
    }

}
