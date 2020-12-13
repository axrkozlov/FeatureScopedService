package com.nurisis.concertinfoproject.ui.scoped

import android.util.Log
import com.nurisis.concertinfoproject.di.ScopeId
import com.nurisis.concertinfoproject.domain.TwoThreeService
import com.nurisis.concertinfoproject.BaseViewModel

class TwoViewModel(scopeId: ScopeId, val twoThreeService: TwoThreeService) : BaseViewModel(scopeId) {


    init {
        Log.i("TwoViewModel", "init: ")
    }

}