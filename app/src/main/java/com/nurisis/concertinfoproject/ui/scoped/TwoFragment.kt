package com.nurisis.concertinfoproject.ui.scoped

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.nurisis.concertinfoproject.R
import com.nurisis.concertinfoproject.di.getScope
import com.nurisis.concertinfoproject.di.Scopes
import kotlinx.android.synthetic.main.two_fragment.*
import org.koin.androidx.viewmodel.ViewModelOwner.Companion.from
import org.koin.androidx.viewmodel.scope.viewModel

class TwoFragment : Fragment() {

    private val viewModel by getScope(Scopes.customScopeId).viewModel<TwoViewModel>(owner = { from(this) })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.two_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        twobutton.setOnClickListener{
            findNavController().navigate(R.id.action_twoFragment_to_threeFragment)
        }

        twobutton2.setOnClickListener{
            viewModel.twoThreeService.someFun()
        }
    }

}