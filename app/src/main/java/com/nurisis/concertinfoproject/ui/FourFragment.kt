package com.nurisis.concertinfoproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nurisis.concertinfoproject.R
import kotlinx.android.synthetic.main.four_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FourFragment : Fragment() {

    private val viewModel by viewModel<FourViewModel>()

//    private val viewModel by viewModel<FourViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.four_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fourbutton.setOnClickListener{
//            customScope.close()
//            findNavController().popBackStack()
        }
    }

}

