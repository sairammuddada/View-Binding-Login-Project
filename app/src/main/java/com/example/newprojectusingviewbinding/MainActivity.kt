package com.example.newprojectusingviewbinding

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newprojectusingviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var activityMainBinding: ActivityMainBinding? = null
    var preferences: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding?.root)
        preferences = getSharedPreferences("UserInfo", 0)
        val userName = activityMainBinding?.txtUser?.text.toString()
        val password = activityMainBinding?.txtPassword?.text.toString()
        val registerUsername = preferences?.getString("username", "")
        val registerPassword = preferences?.getString("password", "")

        activityMainBinding?.button?.setOnClickListener {
            if (userName == registerUsername && password == registerPassword) {
                val intent = Intent(this, SuccessActivity::class.java)
                startActivity(intent)
            }
        }
        activityMainBinding?.createNewAccount?.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}