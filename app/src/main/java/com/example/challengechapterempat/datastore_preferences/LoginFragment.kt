package com.example.challengechapterempat.datastore_preferences

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.findNavController
import com.example.challengechapterempat.R
import com.example.challengechapterempat.databinding.FragmentLoginBinding
import com.example.challengechapterempat.viewmodel.UserViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var userManager: UserManager
    private lateinit var userViewModel: UserViewModel

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

        binding.onClick = this
        userViewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)

        binding.btnLogin.setOnClickListener {
            login()
        }
        binding.tvRegisterLogin.setOnClickListener {
            newRegist()
        }

    }

    private fun checkUser(email: String, password: String) {
        userViewModel.checkUser(email, password).observe(viewLifecycleOwner) {
            if (it == null) {
                Toast.makeText(requireContext(), "Email or password Salah", Toast.LENGTH_SHORT)
                    .show()
            } else {
                GlobalScope.launch {
                    userManager.saveData(username = it.username,email, password, is_login_key = true)
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                }
            }
        }
    }

    fun login() {
        val emailLogin = binding.etEmailLogin.text.toString()
        val passwordLogin = binding.etPasswordLogin.text.toString()
        checkUser(emailLogin,passwordLogin)
    }

    fun newRegist() {
        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }
}