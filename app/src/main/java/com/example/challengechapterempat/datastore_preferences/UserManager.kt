package com.example.challengechapterempat.datastore_preferences

import android.annotation.SuppressLint
import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map


const val PREFERENCE_NAME = "prefs"
class UserManager(private val context: Context) {
    private val Context.datastore by preferencesDataStore(PREFERENCE_NAME)

    private val USERNAME = stringPreferencesKey("username")
    private val EMAIL = stringPreferencesKey("email")
    private val PASSWORD = stringPreferencesKey("password")
    private val IS_LOGIN_KEY = booleanPreferencesKey("is_login")

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile private var instance: UserManager? = null

        fun getInstance(context: Context): UserManager {
            return instance ?: synchronized(this) {
                instance ?: UserManager(context).also { instance = it }
            }
        }
    }

    suspend fun saveData(username:String, email:String, password:String, is_login_key:Boolean){
        context.datastore.edit {
            it [USERNAME] = username
            it [EMAIL] = email
            it [PASSWORD] = password
            it [IS_LOGIN_KEY] = is_login_key
        }
    }

    suspend fun clearData(){
        context.datastore.edit {
            it.clear()
        }
    }

    fun isLoggedIn(): Flow<Boolean> {
        return context.datastore.data
            .map { preferences ->
                preferences[IS_LOGIN_KEY] ?: false
            }
    }

    suspend fun getUsername(): String {
        val preferences = context.datastore.data.first()
        return preferences[USERNAME] ?: ""
    }



    val userPasswordFlow:Flow<String> = context.datastore.data.map {
        it [PASSWORD] ?: ""
    }
    val userEmailFlow:Flow<String> = context.datastore.data.map {
        it [EMAIL]?: ""
    }




}