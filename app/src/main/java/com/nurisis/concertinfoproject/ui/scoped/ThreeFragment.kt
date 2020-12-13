package com.nurisis.concertinfoproject.ui.scoped

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.nurisis.concertinfoproject.R
import com.nurisis.concertinfoproject.di.getScope
import com.nurisis.concertinfoproject.di.Scopes.Companion.customScopeId
import kotlinx.android.synthetic.main.three_fragment.*
import org.koin.androidx.viewmodel.ViewModelOwner
import org.koin.androidx.viewmodel.scope.viewModel

class ThreeFragment : Fragment() {

    // create scope instance
//    val myScope = KoinJavaComponent.getKoin().getOrCreateScope<Container>("qwer")
//    val myScope = KoinJavaComponent.getKoin().getOrCreateScope("qew", named("qwer"))
//    val myScope = getKoin().getScope("qew")
    private val viewModel by getScope(customScopeId).viewModel<ThreeViewModel>(owner = { ViewModelOwner.from(this) })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.three_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        threebutton.setOnClickListener{
            findNavController().navigate(R.id.action_threeFragment_to_fourFragment)
        }
        threebutton2.setOnClickListener{
            viewModel.twoThreeService.someFun()
        }
    }

}