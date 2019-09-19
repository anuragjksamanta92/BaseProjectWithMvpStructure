package com.appsbee.baseprojectwithmvpstructure.pojo

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class User(
    @PrimaryKey open var id: Int = 0,
    open var name: String = "",
    open var email: String = "",
    open var mobile: String = "",
    open var password: String = ""
) : RealmObject() {
    fun get(
        id: Int = this.id,
        name: String = this.name,
        email: String = this.email,
        mobile: String = this.mobile,
        password: String = this.password
    ) = User(id, name, email, mobile, password)
}
