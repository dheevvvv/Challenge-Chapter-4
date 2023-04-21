package com.example.challengechapterempat.datastore_preferences

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.asLiveData
import com.example.challengechapterempat.R
import com.example.challengechapterempat.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var userManager: UserManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userManager = UserManager(requireContext())

        userManager.userEmailFlow.asLiveData().observe(viewLifecycleOwner) {
            binding.etEmailLogin.text = Editable.Factory.getInstance().newEditable(it)
        }
        userManager.userPasswordFlow.asLiveData().observe(viewLifecycleOwner){
            binding.etPasswordLogin.text = Editable.Factory.getInstance().newEditable(it)
        }

    }

    fun login(){

    }

    fun newRegist(){

    }

}