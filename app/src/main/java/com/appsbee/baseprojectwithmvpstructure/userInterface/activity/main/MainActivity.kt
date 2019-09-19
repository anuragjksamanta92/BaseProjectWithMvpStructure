package com.appsbee.baseprojectwithmvpstructure.userInterface.activity.main

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.appsbee.baseprojectwithmvpstructure.R
import com.appsbee.baseprojectwithmvpstructure.dependencyInjection.component.DaggerActivityComponent
import com.appsbee.baseprojectwithmvpstructure.dependencyInjection.module.ActivityModule
import com.appsbee.baseprojectwithmvpstructure.pojo.PlanModel
import com.appsbee.baseprojectwithmvpstructure.pojo.PlanResponse
import com.appsbee.baseprojectwithmvpstructure.userInterface.activity.base.BaseActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.child_view_new.view.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    private var planList: ArrayList<PlanModel>? = null
    private var adapter: RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependency()

        presenter.attach(this)

        recyclerView!!.layoutManager = LinearLayoutManager(this)

    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)
    }

    override fun onResume() {
        super.onResume()

        initView()
    }

    private fun initView() {
        presenter.loadPlans()
    }

    override fun showProgress(showing: Boolean) {
        if (showing)
            progressBar.visibility = View.VISIBLE
        else
            progressBar.visibility = View.GONE
    }

    override fun loadDataSuccess(planResponse: PlanResponse?) {
        planList = planResponse!!.result
        adapter = RecyclerViewAdapter(applicationContext, planList)
        recyclerView.adapter = adapter
    }

    override fun showErrorMessage(error: String?) {
        Log.e("Error", error)
    }

    private class RecyclerViewAdapter(
        private var context: Context,
        private var planList: ArrayList<PlanModel>?
    ) :
        RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

        override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {
            val view =
                LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.child_view_new, viewGroup, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return planList!!.size
        }

        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
            viewHolder.bindView(context, planList, position)
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            fun bindView(
                context: Context,
                planList: java.util.ArrayList<PlanModel>?,
                position: Int
            ) {
                Glide.with(context)
                    .load(planList!![position].iconPath)
                    .into(itemView.circleImageView)
                itemView.textViewName.text = "Name: " + planList!![position].package_name
                itemView.textViewDescription.text = "Description: " + planList[position].description
                itemView.textViewPrice.text = "Price: " + planList[position].price.toString()
            }
        }
    }
}
