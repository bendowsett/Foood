package com.example.foood

import android.app.Application
import com.example.foood.database.AppDatabase

class FooodApplication :Application() {
    val database: AppDatabase by lazy {
        AppDatabase.getDatabase(this)
    }
}