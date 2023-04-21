package com.example.challengechapterempat.datastore_preferences

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


const val PREFERENCE_NAME = "prefs"
class UserManager(private val context: Context) {
    private val Context.datastore by preferencesDataStore(PREFERENCE_NAME)

    private val USERNAME = stringPreferencesKey("username")
    private val PASSWORD = stringPreferencesKey("password")
    private val EMAIL = stringPreferencesKey("email")
    private val FILTER = intPreferencesKey("filter_order")

    suspend fun saveData(username:String, password:String, email:String, filter:Int){
        context.datastore.edit {
            it [USERNAME] = username
            it [PASSWORD] = password
            it [EMAIL] = email
            it [FILTER] = filter
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
    val userFilterFlow:Flow<Int> = context.datastore.data.map {
        it [FILTER]?: 0
    }


}