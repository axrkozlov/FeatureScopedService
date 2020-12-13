package com.nurisis.concertinfoproject.domain

import android.util.Log

class TwoThreeService {

    init {
        Log.i("TwoThreeService", "init = $this ")
    }

    fun someFun() {
        Log.i("TwoThreeService", "someFun: = $this")
    }

    fun onDestroy(){
        Log.i("TwoThreeService", "onDestroy: = $this")
    }
}