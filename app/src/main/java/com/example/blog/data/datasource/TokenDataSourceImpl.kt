package com.example.blog.data.datasource

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject

class TokenDataSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : TokenDataSource {

    companion object {
        private const val KEY_TOKEN = "auth_token"
    }

    override fun getToken(): String? {
        return sharedPreferences.getString(KEY_TOKEN, null)
    }

    override suspend fun saveToken(token: String) {
        sharedPreferences.edit {
            putString(KEY_TOKEN, token)
        }
    }
}
