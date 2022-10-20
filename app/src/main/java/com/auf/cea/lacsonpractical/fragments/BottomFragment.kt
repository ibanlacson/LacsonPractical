package com.auf.cea.lacsonpractical.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.auf.cea.lacsonpractical.MainActivity
import com.auf.cea.lacsonpractical.PREFERENCE_NAME
import com.auf.cea.lacsonpractical.R
import com.auf.cea.lacsonpractical.USERNAME
import com.auf.cea.lacsonpractical.databinding.FragmentBottomBinding

class BottomFragment : Fragment() {
    private lateinit var binding: FragmentBottomBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomBinding.inflate(inflater,container,false)
        sharedPreferences = requireActivity().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username = sharedPreferences.getString(USERNAME,"")
        Log.d(MainActivity::class.java.simpleName,username.toString())
        if(username == "") {
            binding.txtUsername.text = "No username found!"
        } else {
            binding.txtUsername.text = String.format("Username: %s",username.toString())
        }
    }
}