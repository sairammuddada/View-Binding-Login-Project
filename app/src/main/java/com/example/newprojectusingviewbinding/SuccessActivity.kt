package com.example.newprojectusingviewbinding

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newprojectusingviewbinding.databinding.ActivitySuccessBinding

class SuccessActivity : AppCompatActivity() {

    var binding : ActivitySuccessBinding? = null
    var preferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySuccessBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)
        preferences = getSharedPreferences("UserInfo", 0)
        val registerUsername = preferences?.getString("username", "")
        val registerEmail = preferences?.getString("email", "")
        val registerDateOfBirth = preferences?.getString("birthdate", "")
        val registerHome = preferences?.getString("home", "")
        val registerPassword = preferences?.getString("password", "")
        binding?.name?.setText(registerUsername)
        binding?.email?.setText(registerEmail)
        binding?.dob?.setText(registerDateOfBirth)
        binding?.home?.setText(registerHome)
        binding?.password?.setText(registerPassword)
        binding?.Logout?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}