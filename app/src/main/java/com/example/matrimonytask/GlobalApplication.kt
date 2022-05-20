package com.example.matrimonytask

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class GlobalApplication : Application() {
    companion object {
        lateinit var realm : Realm
    }
    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()

        Realm.setDefaultConfiguration(config)


    }


}