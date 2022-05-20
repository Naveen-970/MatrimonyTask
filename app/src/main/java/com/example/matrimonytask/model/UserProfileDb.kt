package com.example.matrimonytask.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class UserProfileDb : RealmObject() {
    var id = 0
    var userName : String? = null
    var userAge : String? = null
    var userHeight : String? = null
    var userSpeakingLanguage : String? = null
    var userQualification : String? = null
    var userAddress : String? = null
    var userImage : String? = null
}