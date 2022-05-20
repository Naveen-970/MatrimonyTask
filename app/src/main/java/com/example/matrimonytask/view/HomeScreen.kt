package com.example.matrimonytask.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.matrimonytask.R
import com.example.matrimonytask.databinding.ActivityHomeScreenBinding
import com.example.matrimonytask.model.UserProfile
import com.example.matrimonytask.model.UserProfileDb
import com.example.matrimonytask.view.adapters.UserProfilesAdapter
import com.example.matrimonytask.viewmodel.HomeScreenViewModel
import io.realm.Realm
import io.realm.RealmResults

class HomeScreen : AppCompatActivity(){
    private val TAG = "HomeScreen"

    var realm: Realm? = null
    private lateinit var binding: ActivityHomeScreenBinding
    private lateinit var viewModel: HomeScreenViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = resources.getColor(R.color.home_screen_top_bg)

        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root )

        viewModel = ViewModelProvider(this).get(HomeScreenViewModel::class.java )


        realm = Realm.getDefaultInstance()
        if (realm != null){
            realm!!.beginTransaction()
            realm!!.deleteAll()
            realm!!.commitTransaction()
        }
        viewModel.addingUsersDataToRealm()
        viewModel.mutableLiveData.observe(this, Observer {
            Log.e(TAG,"First Time Calling")
            val manager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
            binding.rvProfilesData.apply {
                adapter = UserProfilesAdapter(it,this@HomeScreen)
                layoutManager = manager
            }
        })

        binding.imgMenu.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,GestureScreen::class.java)
            startActivity(intent)
        })

    }


    private fun addingUsersDataToRealm() {
        realm?.beginTransaction()
        //userProfileDb = realm!!.where(UserProfileDb::class.java)

        val offline = realm?.createObject(UserProfileDb::class.java)
        if (offline != null) {
            offline.id = 1
            offline.userName = "Priyanka"
            offline.userAge = "27 Yrs"
            offline.userHeight = "5.5 ft 2 in "
            offline.userSpeakingLanguage = "Tamil"
            offline.userQualification = "M.B.B.S"
            offline.userAddress = "Chennai, Tamil Nadu, India."
            realm?.insert(offline)
            realm?.commitTransaction()
            Log.e(TAG,"One Row Inserted")
        }

        realm?.beginTransaction()
        val offline1 = realm?.createObject(UserProfileDb::class.java)
        if (offline1 != null) {
            offline1.id = 1
            offline1.userName = "Priyanka"
            offline1.userAge = "27 Yrs"
            offline1.userHeight = "5.5 ft 2 in "
            offline1.userSpeakingLanguage = "Tamil"
            offline1.userQualification = "M.B.B.S"
            offline1.userAddress = "Chennai, Tamil Nadu, India."
            realm?.insert(offline1)
            realm?.commitTransaction()
            Log.e(TAG,"Second Row Inserted")

        }

        realm?.beginTransaction()
        val offline2 = realm?.createObject(UserProfileDb::class.java)
        if (offline2 != null) {
            offline2.id = 1
            offline2.userName = "Priyanka"
            offline2.userAge = "27 Yrs"
            offline2.userHeight = "5.5 ft 2 in "
            offline2.userSpeakingLanguage = "Tamil"
            offline2.userQualification = "M.B.B.S"
            offline2.userAddress = "Chennai, Tamil Nadu, India."
            realm?.insert(offline2)
            realm?.commitTransaction()
            Log.e(TAG,"Third Row Inserted")
        }

        realm?.beginTransaction()
        if (offline2 != null) {
            offline2.id = 2
            offline2.userName = "Priyanka"
            offline2.userAge = "27 Yrs"
            offline2.userHeight = "5.5 ft 2 in "
            offline2.userSpeakingLanguage = "Tamil"
            offline2.userQualification = "M.B.B.S"
            offline2.userAddress = "Chennai, Tamil Nadu, India."
            realm?.insert(offline2)
            realm?.commitTransaction()
            Log.e(TAG,"Fourth Row Inserted")
        }

    }
    protected fun getAllUserProfiles(): ArrayList<UserProfile> {
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
                    profilesList.add(userProfile)
                }
            }
        }
        return profilesList
    }

}