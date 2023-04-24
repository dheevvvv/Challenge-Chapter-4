package com.example.challengechapterempat.datastore_preferences

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.findNavController
import com.example.challengechapterempat.R
import com.example.challengechapterempat.databinding.FragmentProfileBinding
import com.example.challengechapterempat.viewmodel.UserViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var userManager: UserManager
    private lateinit var userViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userManager = UserManager.getInstance(requireContext())
        userViewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)

        userViewModel.getUsername()
        userViewModel.username.observe(viewLifecycleOwner){
            binding.username = "Hello, Welcome!," + " " + it.toString()
        }
        binding.onClick = this

        binding.btnLogout.setOnClickListener {
            logout()
        }
    }

    fun logout(){
        GlobalScope.async {
            userManager.clearData()
        }
        findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
    }


}