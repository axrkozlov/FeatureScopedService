package com.nurisis.concertinfoproject.di

import android.util.Log
import com.nurisis.concertinfoproject.domain.TwoThreeService
import org.koin.core.scope.*

class Container : KoinScopeComponent {
    override val scope: Scope by lazy { newScope(this) }

//    val twoThreeService:TwoThreeService by scope.inject()

//    val scopeController:ScopeController by inject()
//    init {
//        Log.i("Container", " init $scopeController ")
//        scopeController.onClear = {
//            Log.i("Container", "$scopeController scopeController.onClear: ")
//            onClearServices()
//            closeScope()
//        }
//    }
//
//    fun onClearServices(){
//        val service = scope.get<TwoThreeService>()
//        Log.i("Container", "onClearServices: $service")
//        service.onDestroy()
//    }

    override fun closeScope() {
        Log.i("Container", "  $this: closeScope: ")
//        onClearServices()
        super.closeScope()

    }
    

}