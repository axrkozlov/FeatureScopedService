package com.nurisis.concertinfoproject.di

import android.util.Log
import com.nurisis.concertinfoproject.domain.TwoThreeService

//class ScopeController() {
//
//    var i = 0
//
//    fun add(){
//        i++
//        Log.i("Container", "$this: add: $i")
//    }
//
//    fun remove(){
//        i--
//        Log.i("Container", "$this: remove: $i")
////        if (i<=0) {
////            container.onClearServices()
////            container.closeScope()
////        }
//    }
//}

abstract class ScopeController(val scopeId: ScopeId) {

    val scope = getScope(scopeId)

    var i = 0

    fun link(){
        i++
        Log.i("ScopeController", "$this: add: $i")
    }

    fun unlink(){
        i--
        Log.i("ScopeController", "$this: remove: $i")
        if (i<=0) {
            onClear()
            scope.close()
//            container.onClearServices()
//            container.closeScope()
        }
    }

    abstract fun onClear()
}