package com.example.androidlessonspart3.ui.fragments.navController

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidlessonspart3.R
import com.example.androidlessonspart3.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.bind(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLayout()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun initLayout() {
        binding?.apply {
            salesButton.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_salesFragment)
            }
            refundButton.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_refundFragment)
            }
            settingsButton.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
            }
        }
    }
}