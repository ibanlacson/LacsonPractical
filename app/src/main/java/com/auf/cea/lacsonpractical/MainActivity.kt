package com.auf.cea.lacsonpractical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.auf.cea.lacsonpractical.databinding.ActivityMainBinding
import com.auf.cea.lacsonpractical.fragments.BottomFragment
import com.auf.cea.lacsonpractical.fragments.TopFragment

class MainActivity : AppCompatActivity(), TopFragment.TopFragmentInterface {
    private lateinit var binding : ActivityMainBinding
    private var strUsername = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.replace(binding.frameTopLayout.id, TopFragment())
        fragmentManager.replace(binding.frameBottomLayout.id, BottomFragment())
        fragmentManager.commit()
    }
    
    override fun updateUsername(username: String) {
        strUsername = username
        modifyUsername(username)
    }
    private fun modifyUsername(username: String) {
        val txtUsername = binding.frameBottomLayout.findViewById<TextView>(R.id.txt_username)
        txtUsername.text = String.format("Username: %s",username)
    }
}