package com.appsbee.baseprojectwithmvpstructure.api

import com.appsbee.baseprojectwithmvpstructure.pojo.PlanResponse
import com.appsbee.baseprojectwithmvpstructure.pojo.TargetExamsResponse
import com.appsbee.baseprojectwithmvpstructure.pojo.UserRequest
import com.appsbee.baseprojectwithmvpstructure.util.Constant
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServiceInterface {

    @GET("exams_names")
    fun examNames(): Call<TargetExamsResponse>

    @POST("subscription_Plan_details")
    fun planList(@Body user: UserRequest): Observable<PlanResponse>

    companion object Factory {
        fun create(): ApiServiceInterface {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .build()

            return retrofit.create(ApiServiceInterface::class.java)
        }
    }
}