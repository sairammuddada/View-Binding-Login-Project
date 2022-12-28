package com.example.newprojectusingviewbinding

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newprojectusingviewbinding.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    var binding: ActivityRegisterBinding? = null
    var preferences: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)
        preferences = getSharedPreferences("UserInfo", 0)
        val userName = binding?.name?.text.toString()
        val email = binding?.email?.text.toString()
        val dateOfBirth = binding?.dob?.text.toString()
        val homeAddress = binding?.home?.text.toString()
        val password = binding?.password?.text.toString()

        binding?.register?.setOnClickListener {
            val myEdit: SharedPreferences.Editor = preferences!!.edit()
            myEdit.putString("username", userName)
            myEdit.putString("email", email)
            myEdit.putString("birthdate", dateOfBirth)
            myEdit.putString("home", homeAddress)
            myEdit.putString("password", password)
            myEdit.apply()
            val intent = Intent(this, SuccessActivity::class.java)
            startActivity(intent)
        }
    }
}