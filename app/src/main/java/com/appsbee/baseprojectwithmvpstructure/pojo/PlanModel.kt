package com.appsbee.baseprojectwithmvpstructure.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PlanModel {

    @SerializedName("id")
    @Expose
    var id: Long = 0

    @SerializedName("package_name")
    @Expose
    var package_name: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("price")
    @Expose
    var price: Double = 0.toDouble()

    @SerializedName("price_with_gst")
    @Expose
    var price_with_gst: Double = 0.toDouble()

    @SerializedName("icon_path")
    @Expose
    var iconPath: String? = null


}