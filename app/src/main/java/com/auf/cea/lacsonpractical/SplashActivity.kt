package com.auf.cea.lacsonpractical

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.auf.cea.lacsonpractical.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set SharedPreferences
        sharedPreferences = getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

        // Get Username to sharedPreferences
        val username = sharedPreferences.getString(USERNAME,"")

        //
        if (username != ""){
            binding.txtWelcomeMessage.text = String.format("Welcome to my application, %s",username)
        } else {
            binding.txtWelcomeMessage.text = "Welcome to my application!"
        }


        object : CountDownTimer(5000,1000){
            override fun onTick(p0: Long) {

            }
            override fun onFinish() {
                val intent = Intent(this@SplashActivity,MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }.start()
    }
}