package com.example.sessionmanagment.Preferencea

import android.content.Context
import android.content.SharedPreferences

class PrefManager(context: Context) {
    val PREF_NAME="mukesh"

    val key_name="name"
    val key_email="email"
    val key_password="password"
    val key_login="islogin"

    private var preference :SharedPreferences=
        context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)
    private var editor:SharedPreferences.Editor=preference.edit()

fun Create(name:String,email:String,password:String){
    editor.putString(key_name,"")
    editor.putString(key_email,"")
    editor.putString(key_password,"")
    editor.commit()
}
    fun getName():String?{
        return preference.getString(key_name,"")
    }
    fun getEmail():String?{
        return preference.getString(key_email,"")
    }
    fun getpassword():String?{
        return preference.getString(key_password,"")
    }
    fun updateloginStatus(status:Boolean){
        editor.putBoolean(key_login,status)
        editor.commit()
    }
    fun getLoginStatus():Boolean{
        return preference.getBoolean(key_login,false)
    }
    fun clearData() {
        editor.clear()
        editor.commit()
    }
}