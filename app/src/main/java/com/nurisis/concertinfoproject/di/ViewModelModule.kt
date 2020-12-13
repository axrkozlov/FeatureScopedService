package com.nurisis.concertinfoproject.di

import com.nurisis.concertinfoproject.di.Scopes.Companion.customScopeId
import com.nurisis.concertinfoproject.domain.TwoThreeService
import com.nurisis.concertinfoproject.ui.*
import com.nurisis.concertinfoproject.ui.scoped.CustomScopeController
import com.nurisis.concertinfoproject.ui.scoped.ThreeViewModel
import com.nurisis.concertinfoproject.ui.scoped.TwoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.Scope
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent.getKoin

val viewModelModule = module {
    viewModel { ConcertViewModel(get(),get(),get(),get()) }
    viewModel { OneViewModel() }

    factory { Container() }
    scope<Container> {
        scoped<ScopeController> { CustomScopeController(customScopeId) }
        scoped { TwoThreeService() }

        viewModel { TwoViewModel(customScopeId, get()) }
        viewModel { ThreeViewModel(customScopeId,get()) }

    }
    viewModel { FourViewModel() }
//    scope(named("qwer")) {
//
//        scoped { ScopeController() }
//        scoped { TwoThreeService() }
//        viewModel { TwoViewModel(get()) }
//        viewModel { ThreeViewModel(get()) }
//        viewModel { FourViewModel() }
//    }


//    viewModel {
//        val containerScope = getKoin().getOrCreateScope<Container>("qwer")
//        val vm = TwoViewModel(containerScope.get())
//        vm
//    }
//
//
//    viewModel {
//        val containerScope = getKoin().getOrCreateScope<Container>("qwer")
//        ThreeViewModel(containerScope.get())
//    }

//    fun provideTwoThreeService():TwoThreeService{
//        val containerScope = getKoin().getOrCreateScope<Container>("qwer")
//        return
//    }


//    viewModel { FourViewModel() }
}
//val customScope
//    //get()= KoinJavaComponent.getKoin().getOrCreateScope("qew", named("qwer"))
//    get()=  KoinJavaComponent.getKoin().getOrCreateScope<Container>("qwer")

fun getScope(scopeId: ScopeId):Scope = getKoin().getOrCreateScope<Container>(scopeId.value)

fun getScopeController(scopeId: ScopeId?): ScopeController?{
    return if (scopeId != null) {
        getScope(scopeId).get()
    } else {
        null
    }
}