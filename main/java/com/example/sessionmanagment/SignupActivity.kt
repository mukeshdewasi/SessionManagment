package com.example.sessionmanagment

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sessionmanagment.Preferencea.PrefManager
import com.example.sessionmanagment.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

lateinit var binding:ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            var name=binding.etName.text.toString().trim()
            var email=binding.etEmail2.text.toString().trim()
            var password=binding.etPassword.text.toString().trim()

            createAccount(name,email,password)
        }
    }

    private fun createAccount(name: String, email: String, password: String) {

        var manager=PrefManager(this)
        manager.Create(name,email,password)
        Toast.makeText(this,"Register successfully",Toast.LENGTH_SHORT).show()
        onBackPressed()
    }


}