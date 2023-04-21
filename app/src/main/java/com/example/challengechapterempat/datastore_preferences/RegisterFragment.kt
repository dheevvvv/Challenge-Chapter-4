package com.example.challengechapterempat.datastore_preferences

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.challengechapterempat.R
import com.example.challengechapterempat.databinding.FragmentRegisterBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var userManager: UserManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.onClick = this
        userManager = UserManager(requireContext())
        binding.btnRegister.setOnClickListener {
            register()
        }

    }

    fun register(){
        val username = binding.etUsernameRegist.toString()
        val email = binding.etEmailRegist.toString()
        val password = binding.etPasswordRegist.toString()
        val confirmPassword = binding.etConfirmPasswordRegist.toString()

        if (password != confirmPassword){
            binding.etConfirmPasswordRegist.error = "Confirm password tidak sama dengan password"
            binding.etConfirmPasswordRegist.requestFocus()
            return
        } else{
            GlobalScope.launch {
                userManager.saveData(username,email,password)
            }
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }


}