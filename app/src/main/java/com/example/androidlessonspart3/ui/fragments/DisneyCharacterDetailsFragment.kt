package com.example.androidlessonspart3.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.example.androidlessonspart3.R
import com.example.androidlessonspart3.databinding.FragmentDisneyCharacterDetailsBinding
import com.example.androidlessonspart3.models.api.disney.Data

class DisneyCharacterDetailsFragment : Fragment() {

    companion object {
        const val DISNEY_CHARACTER_DETAILS = "DISNEY_CHARACTER_DETAILS"

        @JvmStatic
        fun newInstance(details: Data): DisneyCharacterDetailsFragment  {
            val fragment = DisneyCharacterDetailsFragment()
            Bundle().apply {
                putParcelable(DISNEY_CHARACTER_DETAILS, details)
            }.also {
                fragment.arguments = it
            }
            return fragment
        }
    }

    private var binding: FragmentDisneyCharacterDetailsBinding? = null

    private var disneyDetails: Data? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("Fragment", "DisneyCharacterDetailsFragment > onCreateView called")
        binding = FragmentDisneyCharacterDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLayout()
    }

    override fun onResume() {
        Log.d("Fragment", "DisneyCharacterDetailsFragment > onResume called")
        super.onResume()
    }

    override fun onPause() {
        Log.d("Fragment", "DisneyCharacterDetailsFragment > onPause called")
        super.onPause()
    }

    override fun onDestroy() {
        Log.d("Fragment", "DisneyCharacterDetailsFragment > onDestroy called")
        super.onDestroy()
        // always make binding = null on destroy
        binding = null
    }

    private fun initLayout() {
        disneyDetails = arguments?.getParcelable(DISNEY_CHARACTER_DETAILS)
        binding?.apply {
            name.text = disneyDetails?.name
            id.text = "ID: ${disneyDetails?._id}"
            url.text = "Url: ${disneyDetails?.url}"
            image.load(disneyDetails?.imageUrl)

            image.setOnClickListener {
                activity?.let {
                    it.supportFragmentManager.beginTransaction()
                        .add(R.id.fragmentContainer, DisneyCharacterDetailsMoreFragment.newInstance())
                        .addToBackStack("")
                        .commitAllowingStateLoss()
                }

            }
        }
    }
}


/*
Explain difference between replace and add.
replace removes the existing fragment and adds a new fragment. This means when you press back button the fragment
that got replaced will be created with its onCreateView being invoked. Whereas add retains the existing fragments
and adds a new fragment that means existing fragment will be active and they wont be in 'paused' state hence when
a back button is pressed onCreateView is not called for the existing fragment(the fragment which was there before
new fragment was added).
 In terms of fragment's life cycle events onPause, onResume, onCreateView and other life cycle events will be invoked
 in case of replace but they wont be invoked in case of add.
 */