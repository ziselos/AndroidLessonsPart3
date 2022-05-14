package com.example.androidlessonspart3.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidlessonspart3.databinding.DisneyCharacterDetailsMoreFragmentBinding
import com.example.androidlessonspart3.databinding.FragmentDisneyCharacterDetailsBinding

class DisneyCharacterDetailsMoreFragment : Fragment() {


    companion object {

        @JvmStatic
        fun newInstance() = DisneyCharacterDetailsMoreFragment()
    }

    private var binding: DisneyCharacterDetailsMoreFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("Fragment", "DisneyCharacterDetailsMoreFragment > onCreateView called")
        binding = DisneyCharacterDetailsMoreFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        Log.d("Fragment", "DisneyCharacterDetailsMoreFragment > onResume called")
        super.onResume()
    }

    override fun onPause() {
        Log.d("Fragment", "DisneyCharacterDetailsMoreFragment > onPause called")
        super.onPause()
    }

    override fun onDestroy() {
        Log.d("Fragment", "DisneyCharacterDetailsMoreFragment > onDestroy called")
        super.onDestroy()
        // always make binding = null on destroy
        binding = null
    }

}