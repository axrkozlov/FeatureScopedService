package com.nurisis.concertinfoproject.ui.scoped

import android.util.Log
import com.nurisis.concertinfoproject.di.ScopeController
import com.nurisis.concertinfoproject.di.ScopeId
import com.nurisis.concertinfoproject.domain.TwoThreeService


 class CustomScopeController(scopeId: ScopeId): ScopeController(scopeId) {

     override fun onClear(){
         val service = scope.get<TwoThreeService>()
         Log.i("ScopeController", "onClearServices: $service")
         service.onDestroy()
     }
}