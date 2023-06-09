package com.example.challengechapterempat.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.challengechapterempat.R
import com.example.challengechapterempat.databases_room.UserData
import com.example.challengechapterempat.databinding.FragmentRegisterBinding
import com.example.challengechapterempat.viewmodel.UserViewModel


class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var userViewModel: UserViewModel


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
        userViewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)
        binding.btnRegister.setOnClickListener {
            register()
        }

    }

    fun saveUser(username : String,email : String,password : String){
        userViewModel.insertUser(UserData(0,username,email,password))
    }
    fun register(){
        val username = binding.etUsernameRegist.text.toString()
        val email = binding.etEmailRegist.text.toString()
        val password = binding.etPasswordRegist.text.toString()
        val confirmPassword = binding.etConfirmPasswordRegist.text.toString()

        if (password != confirmPassword){
            binding.etConfirmPasswordRegist.error = "Confirm password tidak sama dengan password"
            binding.etConfirmPasswordRegist.requestFocus()

        } else{
            saveUser(username,email,password)
            Toast.makeText(context, "Registrasi Berhasil", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
        }
    }
