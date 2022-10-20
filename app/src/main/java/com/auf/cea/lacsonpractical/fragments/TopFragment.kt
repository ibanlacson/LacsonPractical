package com.auf.cea.lacsonpractical.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.auf.cea.lacsonpractical.PREFERENCE_NAME
import com.auf.cea.lacsonpractical.R
import com.auf.cea.lacsonpractical.USERNAME
import com.auf.cea.lacsonpractical.databinding.FragmentTopBinding

class TopFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentTopBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var topFragmentInterface: TopFragmentInterface

    private var username = ""

    interface TopFragmentInterface {
        fun updateUsername(username:String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        topFragmentInterface = context as TopFragmentInterface
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTopBinding.inflate(inflater,container,false)
        sharedPreferences = requireActivity().getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        username = sharedPreferences.getString(USERNAME,"").toString()
        binding.edtTxtUsername.setText(username)

        binding.btnSaveUsername.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            (R.id.btn_save_username) -> {
                username = binding.edtTxtUsername.text.toString()
                if (username.isEmpty()){
                    binding.edtTxtUsername.error = "Required"
                    return
                } else if (username.length < 6) {
                    binding.edtTxtUsername.error = "Username should be more than 6 characters long"
                    return
                } else {
                    val editor = sharedPreferences.edit()
                    editor.putString(USERNAME,username)
                    editor.apply()

                    topFragmentInterface.updateUsername(username)
                }

            }
        }
    }

}