package com.example.sessionmanagment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashScreen : AppCompatActivity() {

    val PREF_NAME="mukesh"

    val key_login="islogin"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Thread(Runnable {
          kotlin.run{
              Thread.sleep(3000)
              var preferences=getSharedPreferences(PREF_NAME, MODE_PRIVATE)
              var status=preferences.getBoolean(key_login,true)

              if (!status){
                  startActivity(Intent(this,LoginActivity::class.java))
              }else{
                  startActivity(Intent(this,HomeActivity::class.java))
              }
          }
        }).start()
    }
}