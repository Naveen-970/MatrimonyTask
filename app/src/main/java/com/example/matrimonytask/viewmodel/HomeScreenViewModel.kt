package com.example.matrimonytask.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.matrimonytask.model.UserProfile
import com.example.matrimonytask.model.UserProfileDb
import io.realm.Realm
import io.realm.RealmResults

class HomeScreenViewModel: ViewModel() {

    var mutableLiveData = MutableLiveData<ArrayList<UserProfile>>()

    fun getAllProfiles(): MutableLiveData<ArrayList<UserProfile>> {
        loadProfiles()
        return mutableLiveData
    }

    fun addingUsersDataToRealm() {
        val realm = Realm.getDefaultInstance()
        realm?.beginTransaction()
        //userProfileDb = realm!!.where(UserProfileDb::class.java)

        val offline = realm?.createObject(UserProfileDb::class.java)
        if (offline != null) {
            offline.id = 1
            offline.userName = "Priyamani"
            offline.userAge = "30 Yrs"
            offline.userHeight = "5.5 ft 2 in "
            offline.userSpeakingLanguage = "Telugu"
            offline.userQualification = "B. Tech"
            offline.userAddress = "Hyderabad, Telangana, India."
            offline.userImage = "https://www.telugu360.com/wp-content/uploads/2022/02/Priyamani_7.jpg"
            realm.insert(offline)
            realm.commitTransaction()
        }

        realm.beginTransaction()
        val offline1 = realm?.createObject(UserProfileDb::class.java)
        if (offline1 != null) {
            offline1.id = 2
            offline1.userName = "Nidhi Agarwal"
            offline1.userAge = "28 Yrs"
            offline1.userHeight = "5 ft 2 in "
            offline1.userSpeakingLanguage = "Hindi"
            offline1.userQualification = "M. Tech"
            offline1.userAddress = "Mumbai, Maharashtra, India."
            offline1.userImage = "https://www.telugu360.com/wp-content/uploads/2022/01/Nidhi-Agarwal-interview_2.jpg"
            realm.insert(offline1)
            realm.commitTransaction()
        }

        realm.beginTransaction()
        val offline2 = realm?.createObject(UserProfileDb::class.java)
        if (offline2 != null) {
            offline2.id = 3
            offline2.userName = "Keerthi Shetty"
            offline2.userAge = "24 Yrs"
            offline2.userHeight = "5 ft 2 in "
            offline2.userSpeakingLanguage = "Kanada"
            offline2.userQualification = "M. Tech"
            offline2.userAddress = "Bengaluru, Karnataka, India."
            offline2.userImage = "https://www.telugu360.com/wp-content/uploads/2022/01/Krithi-Shetty-Interview_6.jpg"
            realm.insert(offline2)
            realm.commitTransaction()
        }

        realm.beginTransaction()
        val offline3 = realm?.createObject(UserProfileDb::class.java)
        if (offline3 != null) {
            offline3.id = 4
            offline3.userName = "Rashmika"
            offline3.userAge = "26 Yrs"
            offline3.userHeight = "5.3 ft 2 in "
            offline3.userSpeakingLanguage = "Kanada"
            offline3.userQualification = "Degree"
            offline3.userAddress = "Bengaluru, Karnataka, India."
            offline3.userImage = "https://www.telugu360.com/wp-content/uploads/2021/12/Rashmika-at-Pushpa-Movie-Press-Meet_5.jpg"
            realm.insert(offline3)
            realm.commitTransaction()
        }

        realm.beginTransaction()
        val offline4 = realm?.createObject(UserProfileDb::class.java)
        if (offline4 != null) {
            offline4.id = 5
            offline4.userName = "Sai Pallavi"
            offline4.userAge = "27 Yrs"
            offline4.userHeight = "5 ft 2 in "
            offline4.userSpeakingLanguage = "Maliyalam"
            offline4.userQualification = "M.B.B.S"
            offline4.userAddress = "Tiruvananthapuram, Kerala, India."
            offline4.userImage = "https://www.telugu360.com/wp-content/uploads/2021/12/Sai-Pallavi_2.jpg"
            realm.insert(offline4)
            realm.commitTransaction()
        }

        getAllProfiles()
    }

    protected fun loadProfiles(){
        val realm = Realm.getDefaultInstance()
        val scanCategories: RealmResults<UserProfileDb>? = realm.where(UserProfileDb::class.java).findAll()

        val profilesList = ArrayList<UserProfile>()
        if (scanCategories != null) {
            for (item in 0 until scanCategories.size){
                val userProfileDb = scanCategories.get(item)
                if (userProfileDb != null) {
                    val userProfile = UserProfile()
                    userProfile.userName = userProfileDb.userName.toString()
                    val userProfileFullDetails = userProfileDb.userAge +", "+
                            userProfileDb.userHeight +", "+
                            userProfileDb.userSpeakingLanguage +", "+
                            userProfileDb.userQualification +", "+
                            userProfileDb.userAddress
                    userProfile.userProfileDetails = userProfileFullDetails
                    userProfile.userImageURL = userProfileDb.userImage
                    profilesList.add(userProfile)
                }
            }
            mutableLiveData.value = profilesList
        }
    }

}