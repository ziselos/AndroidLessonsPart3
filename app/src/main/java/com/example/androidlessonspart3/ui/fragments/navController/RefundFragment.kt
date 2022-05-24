package com.example.androidlessonspart3.ui.fragments.navController

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidlessonspart3.R
import com.example.androidlessonspart3.databinding.FragmentRefundBinding

class RefundFragment: Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = RefundFragment()
    }

    private var binding: FragmentRefundBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_refund, container, false)
        binding = FragmentRefundBinding.bind(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}