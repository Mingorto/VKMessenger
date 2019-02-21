package com.strangelove.vkmessenger.model.data

import android.content.SharedPreferences

class StorageUtil(private val editor: SharedPreferences.Editor) {
    fun saveString(name: String, value: String) {
        editor.putString(name, value)
        editor.commit()
    }

    fun saveInt(name: String, value: Int) {
        editor.putInt(name, value)
        editor.commit()
    }

    fun saveLong(name: String, value: Long) {
        editor.putLong(name, value)
        editor.commit()
    }

    fun saveFloat(name: String, value: Float) {
        editor.putFloat(name, value)
        editor.commit()
    }
}