package com.example.challengechapterempat.datastore_preferences

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


const val PREFERENCE_NAME = "prefs"
class UserManager(val context: Context) {
    val Context.datastore by preferencesDataStore(PREFERENCE_NAME)

    val EMAIL = stringPreferencesKey("email")
    val PASSWORD = stringPreferencesKey("password")

    suspend fun saveData(email:String, password:String){
        context.datastore.edit {
            it [EMAIL] = email
            it [PASSWORD] = password
        }
    }

    suspend fun clearData(){
        context.datastore.edit {
            it.clear()
        }
    }

    val userPasswordFlow:Flow<String> = context.datastore.data.map {
        it [PASSWORD] ?: ""
    }
    val userEmailFlow:Flow<String> = context.datastore.data.map {
        it [EMAIL]?: ""
    }

}