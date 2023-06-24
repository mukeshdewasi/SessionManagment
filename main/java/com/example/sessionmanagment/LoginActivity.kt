package com.example.sessionmanagment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sessionmanagment.Preferencea.PrefManager
import com.example.sessionmanagment.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            var intent=Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            var email=binding.etEmail.text.toString()
            var password=binding.etPassword.text.toString().trim()

            login(email,password)
        }
    }

    private fun login(email: String, password: String) {
       var manager=PrefManager(this)
        var memail=manager.getEmail()
        var mpass=manager.getpassword()
        var mname=manager.getName()

        if (email==memail&&password==mpass){
           manager.updateloginStatus(true   )

            Toast.makeText(this,"welcome,$mname",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,HomeActivity::class.java))
        }else{
            Toast.makeText(this,"invalid credential",Toast.LENGTH_SHORT).show()
        }

    }
}