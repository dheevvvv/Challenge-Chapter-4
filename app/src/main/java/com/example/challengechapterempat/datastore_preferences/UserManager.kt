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

    val USERNAME = stringPreferencesKey("username")
    val PASSWORD = stringPreferencesKey("password")
    val EMAIL = stringPreferencesKey("email")
    val FILTER = intPreferencesKey("filter_order")

    suspend fun saveData(username:String, password:String, email:String){
        context.datastore.edit {
            it [USERNAME] = username
            it [PASSWORD] = password
            it [EMAIL] = email
        }
    }

    suspend fun clearData(){
        context.datastore.edit {
            it.clear()
        }
    }

    val userUsernameFlow: Flow<String> = context.datastore.data.map {
        it [USERNAME] ?: ""
    }
    val userPasswordFlow:Flow<String> = context.datastore.data.map {
        it [PASSWORD] ?: ""
    }
    val userEmailFlow:Flow<String> = context.datastore.data.map {
        it [EMAIL]?: ""
    }


}