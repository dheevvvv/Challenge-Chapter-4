package com.example.challengechapterempat.shared_preferences

import android.content.Context
import android.content.SharedPreferences

class FilterPreferences(context: Context) {
    private val sharedPrefName = "sharedPrefFilter"
    private lateinit var sharedPreferences:SharedPreferences

    init {
        sharedPreferences =  context.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE)
    }

    fun put(key: String, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value).apply()
    }

    fun clear(){
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

}