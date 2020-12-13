package com.nurisis.concertinfoproject

import android.util.Log
import androidx.lifecycle.ViewModel
import com.nurisis.concertinfoproject.di.getScopeController
import com.nurisis.concertinfoproject.di.ScopeController
import com.nurisis.concertinfoproject.di.ScopeId

abstract class BaseViewModel(scopeId: ScopeId? = null) : ViewModel() {


    private val scopeController: ScopeController? = getScopeController(scopeId)

    init {
        scopeController?.link()
        Log.i("BaseViewModel", ":scopeController= $scopeController")
    }

    override fun onCleared() {
        scopeController?.unlink()
        super.onCleared()
    }
}