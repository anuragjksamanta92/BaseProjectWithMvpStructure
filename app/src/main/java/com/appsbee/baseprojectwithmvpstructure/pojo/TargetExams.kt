package com.appsbee.baseprojectwithmvpstructure.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.io.Serializable

class TargetExams : Serializable {

    @SerializedName("id")
    @Expose
    var id: Int = 0

    @SerializedName("exam_name")
    @Expose
    var examName: String? = null

    @SerializedName("state_name")
    @Expose
    var stateName: String? = null

    @SerializedName("state_id")
    @Expose
    var stateId: Int = 0
}
