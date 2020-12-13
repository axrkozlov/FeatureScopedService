package com.nurisis.concertinfoproject.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.nurisis.concertinfoproject.R
import kotlinx.android.synthetic.main.one_fragment.*
import kotlinx.android.synthetic.main.two_fragment.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class OneFragment : Fragment() {

    companion object {
        fun newInstance() = OneFragment()
    }

    private val viewModel by viewModel<OneViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.one_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
        onebutton.setOnClickListener{
            findNavController().navigate(R.id.action_oneFragment_to_twoFragment)
        }
//        onebutton2.setOnClickListener{
//            customScope.close()
//        }
    }

}